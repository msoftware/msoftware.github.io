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

package android.databinding.tool

import android.databinding.tool.store.LayoutInfoInput
import android.databinding.tool.store.LayoutInfoLog
import android.databinding.tool.store.ResourceBundle
import android.databinding.tool.writer.BaseLayoutBinderWriter
import android.databinding.tool.writer.BaseLayoutModel
import android.databinding.tool.writer.JavaFileWriter
import com.squareup.javapoet.JavaFile

@Suppress("unused")// used by tools
class BaseDataBinder(
        val input : LayoutInfoInput) {
    private val resourceBundle : ResourceBundle = ResourceBundle(
            input.packageName, input.args.useAndroidX)
    init {
        input.filesToConsider
                .forEach {
                    it.inputStream().use {
                        val bundle = ResourceBundle.LayoutFileBundle.fromXML(it)
                        resourceBundle.addLayoutBundle(bundle, true)
                    }
                }
        resourceBundle.addDependencyLayouts(input.existingBindingClasses)
        resourceBundle.validateMultiResLayouts()
    }
    @Suppress("unused")// used by android gradle plugin
    fun generateAll(writer : JavaFileWriter) {
        val libTypes = LibTypes(useAndroidX = input.args.useAndroidX)
        input.invalidatedClasses.forEach {
            writer.deleteFile(it)
        }
        val myLog = LayoutInfoLog()
        myLog.addAll(input.unchangedLog)
        resourceBundle.layoutFileBundlesInSource.groupBy { it.mFileName }.forEach {
            // generate only if this belongs to us, otherwise, it is already generated in
            // the dependency
            val binderWriter = BaseLayoutBinderWriter(BaseLayoutModel(it.value), libTypes)
            val spec = binderWriter.write()
            val sb = StringBuilder()
            val pkg = it.value[0].bindingClassPackage
            JavaFile.builder(pkg, spec).build()
                    .writeTo(sb)
            val className = it.value[0].bindingClassPackage + "." + it.value[0]
                    .bindingClassName
            writer.writeToFile(className, sb.toString())
            myLog.classInfoLog.addMapping(it.key, binderWriter.generateClassInfo())

            val layoutName = it.key
            it.value.forEach {
                it.bindingTargetBundles.forEach { bundle ->
                    if (bundle.isBinder) {
                        myLog.addDependency(layoutName, bundle.includedLayout)
                    }
                }
            }
        }
        input.saveLog(myLog)
    }
}
