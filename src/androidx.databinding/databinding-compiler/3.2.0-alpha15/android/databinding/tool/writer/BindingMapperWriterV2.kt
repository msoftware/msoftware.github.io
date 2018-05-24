/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.databinding.tool.writer

import android.databinding.tool.CompilerArguments
import android.databinding.tool.LibTypes
import android.databinding.tool.ext.L
import android.databinding.tool.ext.N
import android.databinding.tool.ext.S
import android.databinding.tool.ext.T
import android.databinding.tool.ext.stripNonJava
import android.databinding.tool.reflection.ModelAnalyzer
import android.databinding.tool.store.GenClassInfoLog
import com.squareup.javapoet.AnnotationSpec
import com.squareup.javapoet.ArrayTypeName
import com.squareup.javapoet.ClassName
import com.squareup.javapoet.CodeBlock
import com.squareup.javapoet.FieldSpec
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.ParameterSpec
import com.squareup.javapoet.ParameterizedTypeName
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import java.util.Locale
import javax.annotation.Generated
import javax.lang.model.element.Modifier

class BindingMapperWriterV2(private val genClassInfoLog: GenClassInfoLog,
                            compilerArgs: CompilerArguments,
                            libTypes: LibTypes) {
    companion object {
        private val VIEW = ClassName
                .get("android.view", "View")
        private val OBJECT = ClassName
                .get("java.lang", "Object")
        private val RUNTIME_EXCEPTION = ClassName
                .get("java.lang", "RuntimeException")
        private val ILLEGAL_ARG_EXCEPTION = ClassName
                .get("java.lang", "IllegalArgumentException")
        private val STRING = ClassName
                .get("java.lang", "String")
        private val LAYOUT_ID_LOOKUP_MAP_NAME = "INTERNAL_LAYOUT_ID_LOOKUP"
        private val IMPL_CLASS_NAME = "DataBinderMapperImpl"
        private val SPARSE_INT_ARRAY =
                ClassName.get("android.util", "SparseIntArray")
        private val SPARSE_ARRAY =
                ClassName.get("android.util", "SparseArray")

        @JvmStatic
        fun createMapperQName(modulePackage : String) = modulePackage + "." + IMPL_CLASS_NAME
    }

    private val rClassMap = mutableMapOf<String, ClassName>()

    private val viewDataBinding = ClassName.bestGuess(libTypes.viewDataBinding)
    private val bindingComponent = ClassName.bestGuess(libTypes.dataBindingComponent)
    private val dataBinderMapper: ClassName = ClassName.bestGuess(libTypes.dataBinderMapper)
    private val testOverride: ClassName = ClassName.get(
            libTypes.bindingPackage,
            MergedBindingMapperWriter.TEST_CLASS_NAME)


    val pkg : String
    val className : String
    init {
        val generateAsTest = compilerArgs.isTestVariant && compilerArgs.isApp
        if(generateAsTest) {
            pkg = testOverride.packageName()
            className = testOverride.simpleName()
        } else {
            pkg = compilerArgs.modulePackage
            className = IMPL_CLASS_NAME
        }
    }

    val qualifiedName = "$pkg.$className"

    private fun getRClass(pkg: String): ClassName {
        return rClassMap.getOrPut(pkg) {
            ClassName.get(pkg, "R")
        }
    }

    /**
     * Layout ids might be non-final while generating the mapper for a library.
     * For that case, we generate an internal lookup table that converts an R file into a local
     * known field value.
     */
    private val localizedLayoutIdMap = mutableMapOf<String, LayoutId>()

    data class LayoutId(val pkg: String, val id: Int, val layoutName: String,
                        val fieldSpec: FieldSpec)

    private fun getLocalizedLayoutId(pkg: String, layoutName: String): FieldSpec {
        val layoutId = localizedLayoutIdMap.getOrPut(layoutName) {
            val fieldName = "LAYOUT_${layoutName.stripNonJava().toUpperCase(Locale.US)}"
            // must be > 0
            val id = localizedLayoutIdMap.size + 1
            val spec = FieldSpec.builder(TypeName.INT, fieldName,
                    Modifier.FINAL, Modifier.STATIC, Modifier.PRIVATE)
                    .initializer(L, id)
                    .build()
            LayoutId(
                    pkg = pkg,
                    layoutName = layoutName,
                    id = id,
                    fieldSpec = spec)
        }
        return layoutId.fieldSpec
    }

    fun write(brValueLookup: MutableMap<String, Int>): TypeSpec = TypeSpec.classBuilder(className).apply {
        superclass(dataBinderMapper)
        addModifiers(Modifier.PUBLIC)
        if (ModelAnalyzer.getInstance().hasGeneratedAnnotation()) {
            addAnnotation(AnnotationSpec.builder(Generated::class.java).apply {
                addMember("value", S, "Android Data Binding")
            }.build())
        }
        addMethod(generateGetViewDataBinder())
        addMethod(generateGetViewArrayDataBinder())
        addMethod(generateGetLayoutId())
        addMethod(generateConvertBrIdToString())
        addType(generateInnerBrLookup(brValueLookup))
        // must write this at the end
        createLocalizedLayoutIds(this)
    }.build()

    private fun createLocalizedLayoutIds(builder: TypeSpec.Builder) {
        /**
         * generated code looks like:
         * private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP =
         *         new SparseIntArray(99);
         *     static {
         *         INTERNAL_LAYOUT_ID_LOOKUP.put(
         *             foo.bar.R.layout.generic_view, LAYOUT_GENERICVIEW);
         *         ... //for all layouts
         *     }
         */
        builder.apply {
            // create fields
            localizedLayoutIdMap.forEach {
                addField(it.value.fieldSpec)
            }
            // now create conversion hash map
            // reverse map from ids to values
            val lookupType = SPARSE_INT_ARRAY
            val lookupField = FieldSpec.builder(
                    lookupType,
                    LAYOUT_ID_LOOKUP_MAP_NAME)
                    .addModifiers(Modifier.PRIVATE, Modifier.FINAL, Modifier.STATIC)
                    .initializer("new $T($L)", lookupType, localizedLayoutIdMap.size)
                    .build()
            addField(lookupField)
            addStaticBlock(CodeBlock.builder().apply {
                localizedLayoutIdMap.values.forEach {
                    addStatement("$N.put($L.layout.$L, $N)", lookupField,
                            getRClass(it.pkg), it.layoutName, it.fieldSpec)
                }
            }.build())
        }
    }

    private fun generateInnerBrLookup(brValueLookup: MutableMap<String, Int>) = TypeSpec
            .classBuilder("InnerBrLookup").apply {
        /**
         * generated code looks like:
         * static final SparseArray<String> sKeys = new SparseArray<String>(214);
         * static {
         *     sKeys.put(foo.bar.BR._all, "_all");
         *     ....//for all BRs
         */
        addModifiers(Modifier.PRIVATE, Modifier.STATIC)
        val keysTypeName = ParameterizedTypeName.get(
                SPARSE_ARRAY,
                STRING
        )
        val keysField = FieldSpec.builder(keysTypeName, "sKeys").apply {
            addModifiers(Modifier.STATIC, Modifier.FINAL)
            initializer("new $T($L)", keysTypeName, brValueLookup.size + 1)
        }.build()
        addField(keysField)
        addStaticBlock(CodeBlock.builder().apply {
            brValueLookup.forEach {
                addStatement("$N.put($L, $S)",
                        keysField,
                        it.value,
                        it.key)
            }
        }.build())
    }.build()

    private fun generateConvertBrIdToString() = MethodSpec
            .methodBuilder("convertBrIdToString").apply {
        addModifiers(Modifier.PUBLIC)
        addAnnotation(Override::class.java)
        val idParam = ParameterSpec.builder(TypeName.INT, "id").build()
        addParameter(idParam)
        returns(STRING)
        val tmpResult = "tmpVal"
        addStatement("$T $L = InnerBrLookup.sKeys.get($N)", STRING, tmpResult, idParam)
        addStatement("return $L", tmpResult)
    }.build()

    private fun generateGetLayoutId() = MethodSpec.methodBuilder("getLayoutId").apply {
        addModifiers(Modifier.PUBLIC)
        addAnnotation(Override::class.java)
        val tagParam = ParameterSpec.builder(STRING, "tag").build()
        addParameter(tagParam)
        returns(TypeName.INT)
        beginControlFlow("if ($N == null)", tagParam).apply {
            addStatement("return 0")
        }.endControlFlow()

        // output looks like
        // switch has code of tag parameter
        //    case <known hash> (known tags grouped by hash)
        //         find matching tag via equals and return

        // String.hashCode is well defined in the API so we can rely on it being the same on
        // the device and the host machine
        addStatement("final $T code = $N.hashCode()", TypeName.INT, tagParam)
        beginControlFlow("switch(code)").apply {
            genClassInfoLog.mappings()
                    .flatMap { mapping ->
                        mapping.value.implementations
                                .map { Pair(it, mapping) }
                    }
                    .groupBy { (first) ->
                        (first.tag + "_0").hashCode()
                    }
                    .forEach { code, pairs ->
                        beginControlFlow("case $L:", code).apply {
                            pairs.forEach {
                                val rClass = getRClass(it.second.value.modulePackage)
                                beginControlFlow("if($N.equals($S))",
                                        tagParam, "${it.first.tag}_0").apply {
                                    addStatement("return $T.layout.$L", rClass, it.second.key)
                                }.endControlFlow()
                            }
                            addStatement("break")
                        }.endControlFlow()
                    }
        }.endControlFlow()
        addStatement("return 0")
    }.build()

    private fun generateGetViewDataBinder(): MethodSpec {
        return MethodSpec.methodBuilder("getDataBinder").apply {
            addModifiers(Modifier.PUBLIC)
            addAnnotation(Override::class.java)
            returns(viewDataBinding)
            val componentParam = ParameterSpec.builder(bindingComponent, "component").build()
            val viewParam = ParameterSpec.builder(VIEW, "view").build()
            val layoutIdParam = ParameterSpec.builder(TypeName.INT, "layoutId").build()
            addParameter(componentParam)
            addParameter(viewParam)
            addParameter(layoutIdParam)
            val localizedLayoutId = "localizedLayoutId"
            addStatement("$T $L = $L.get($N)",
                    TypeName.INT,
                    localizedLayoutId,
                    LAYOUT_ID_LOOKUP_MAP_NAME,
                    layoutIdParam)
            // output looks like:
            // localize layout id from R.layout.XY to local private constant
            // switch(layoutId)
            //    case known_layout_id
            //             verify, generate impl and return
            beginControlFlow("if($L > 0)", localizedLayoutId).apply {
                addStatement("final $T tag = $N.getTag()", OBJECT, viewParam)
                beginControlFlow("if(tag == null)").apply {
                    addStatement("throw new $T($S)", RUNTIME_EXCEPTION,
                            "view must have a tag")
                }.endControlFlow()
                beginControlFlow("switch($N)", localizedLayoutId).apply {
                    genClassInfoLog.mappings().forEach { layoutName, info ->
                        val layoutIdField = getLocalizedLayoutId(info.modulePackage, layoutName)
                        beginControlFlow("case  $N:", layoutIdField).apply {
                            // we should check the tag to decide which layout we need to inflate
                            // we do it here because it is ok to pass a non-data-binding layout
                            info.implementations.forEach {
                                beginControlFlow("if ($S.equals(tag))",
                                        "${it.tag}_0").apply {
                                    val binderTypeName = ClassName.bestGuess(it.qualifiedName)
                                    if (it.merge) {
                                        addStatement("return new $T($N, new $T[]{$N})",
                                                binderTypeName, componentParam, VIEW, viewParam)
                                    } else {
                                        addStatement("return new $T($N, $N)",
                                                binderTypeName, componentParam, viewParam)
                                    }
                                }.endControlFlow()
                            }
                            addStatement("throw new $T($S + tag)", ILLEGAL_ARG_EXCEPTION,
                                    "The tag for $layoutName is invalid. Received: ")
                        }.endControlFlow()
                    }
                }.endControlFlow()
            }.endControlFlow()
            addStatement("return null")
        }.build()
    }

    private fun generateGetViewArrayDataBinder() = MethodSpec.methodBuilder("getDataBinder")
            .apply {
                addModifiers(Modifier.PUBLIC)
                addAnnotation(Override::class.java)
                returns(viewDataBinding)
                val componentParam = ParameterSpec.builder(bindingComponent, "component").build()
                val viewParam = ParameterSpec.builder(ArrayTypeName.of(VIEW), "views").build()
                val layoutIdParam = ParameterSpec.builder(TypeName.INT, "layoutId").build()
                addParameter(componentParam)
                addParameter(viewParam)
                addParameter(layoutIdParam)
                beginControlFlow("if($N == null || $N.length == 0)",
                        viewParam, viewParam).apply {
                    addStatement("return null")
                }.endControlFlow()

                val localizedLayoutId = "localizedLayoutId"
                addStatement("$T $L = $L.get($N)",
                        TypeName.INT,
                        localizedLayoutId,
                        LAYOUT_ID_LOOKUP_MAP_NAME,
                        layoutIdParam)
                // output looks like:
                // localize layout id from R.layout.XY to local private constant
                // switch(layoutId)
                //    case known_layout_id
                //             verify, generate impl and return

                beginControlFlow("if($L > 0)", localizedLayoutId).apply {
                    addStatement("final $T tag = $N[0].getTag()", OBJECT, viewParam)
                    beginControlFlow("if(tag == null)").apply {
                        addStatement("throw new $T($S)", RUNTIME_EXCEPTION,
                                "view must have a tag")
                    }.endControlFlow()
                    beginControlFlow("switch($N)", localizedLayoutId).apply {
                        genClassInfoLog.mappings().forEach { layoutName, info ->
                            val mergeImpls = info.implementations.filter { it.merge }
                            if (mergeImpls.isNotEmpty()) {
                                val layoutIdField = getLocalizedLayoutId(
                                        info.modulePackage,
                                        layoutName)
                                beginControlFlow("case $N:", layoutIdField).apply {
                                    mergeImpls.forEach {
                                        beginControlFlow("if($S.equals(tag))",
                                                "${it.tag}_0").apply {
                                            val binderTypeName = ClassName.bestGuess(
                                                    it.qualifiedName)
                                            addStatement("return new $T($N, $N)",
                                                    binderTypeName, componentParam, viewParam)
                                        }.endControlFlow()
                                    }
                                    addStatement("throw new $T($S + tag)", ILLEGAL_ARG_EXCEPTION,
                                            "The tag for $layoutName is invalid. Received: ")
                                }.endControlFlow()
                            }
                        }
                    }.endControlFlow()
                }.endControlFlow()

                addStatement("return null")
            }.build()
}
