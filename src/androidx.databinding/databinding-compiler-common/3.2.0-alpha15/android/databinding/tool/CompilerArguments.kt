/*
 * Copyright (C) 2016 The Android Open Source Project
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

import android.databinding.tool.util.Preconditions
import com.google.common.collect.Sets
import java.io.File
import java.util.HashMap

@Suppress("unused")
/**
 * This class is used to pass information from the build system into the data binding compiler.
 * It can serialize itself to a given list of annotation processor options and read itself
 * from there.
 */
class CompilerArguments constructor(
    val artifactType: Type,
    val modulePackage: String,
    val minApi: Int,

    // the SDK directory
    val sdkDir: File,

    // the folder used by data binding to read data about the build process.
    val buildDir: File,

    // output of the process layouts task
    val layoutInfoDir: File,

    // log file created by GenBaseClassesTask which is used to generate implementations in the data
    // binding annotation processor
    val classLogDir: File,

    // set when compiling a base feature, includes the package ids of all features
    val baseFeatureInfoDir: File?,

    // set when compiling a feature, includes the features id offset as well as the BR files it
    // is responsible to generate
    val featureInfoDir: File?,

    // the folder where generational class files are exported, only set in library builds
    val aarOutDir: File?,

    // the file into which data binding will output the list of classes that should be stripped in
    // the packaging phase
    val exportClassListOutFile: File?,

    val enableDebugLogs: Boolean,
    val printEncodedErrorLogs: Boolean,
    val isTestVariant: Boolean,
    val isEnabledForTests: Boolean,
    val isEnableV2: Boolean
) {
    init {
        Preconditions.check(
            artifactType != Type.FEATURE || featureInfoDir != null,
            "Must provide a feature info folder while compiling a non-base feature module"
        )
        Preconditions.check(
            artifactType != Type.LIBRARY || isTestVariant || aarOutDir != null,
            "Must specify bundle folder (aar out folder) for library projects"
        )
        Preconditions.check(
            artifactType != Type.LIBRARY || isTestVariant || exportClassListOutFile != null,
            "Must provide a folder to export generated class list"
        )
    }

    val isApp: Boolean
        get() = artifactType == Type.APPLICATION

    val isLibrary: Boolean
        get() = artifactType == Type.LIBRARY

    val isFeature: Boolean
        get() = artifactType == Type.FEATURE

    /**
     * Creates a copy of the arguments but sets the version to v1 and package to the given package.
     * This is used when we need to run a compatibility compilation for v1 dependencies.
     */
    fun copyAsV1(modulePackage: String): CompilerArguments {
        val argMap = toMap().toMutableMap()
        argMap[PARAM_MODULE_PACKAGE] = modulePackage
        argMap[PARAM_ENABLE_V2] = booleanToString(false)
        return readFromOptions(argMap)
    }

    fun toMap(): Map<String, String> {
        val args = HashMap<String, String>()
        args[PARAM_ARTIFACT_TYPE] = artifactType.name
        args[PARAM_MODULE_PACKAGE] = modulePackage
        args[PARAM_MIN_API] = minApi.toString()
        args[PARAM_SDK_DIR] = sdkDir.path
        args[PARAM_BUILD_DIR] = buildDir.path
        args[PARAM_LAYOUT_INFO_DIR] = layoutInfoDir.path
        args[PARAM_CLASS_LOG_DIR] = classLogDir.path
        baseFeatureInfoDir?.let { args[PARAM_BASE_FEATURE_INFO_DIR] = it.path }
        featureInfoDir?.let { args[PARAM_FEATURE_INFO_DIR] = it.path }
        aarOutDir?.let { args[PARAM_AAR_OUT_DIR] = it.path }
        exportClassListOutFile?.let { args[PARAM_EXPORT_CLASS_LIST_OUT_FILE] = it.path }
        args[PARAM_ENABLE_DEBUG_LOGS] = booleanToString(enableDebugLogs)
        args[PARAM_PRINT_ENCODED_ERROR_LOGS] = booleanToString(printEncodedErrorLogs)
        args[PARAM_IS_TEST_VARIANT] = booleanToString(isTestVariant)
        args[PARAM_ENABLE_FOR_TESTS] = booleanToString(isEnabledForTests)
        args[PARAM_ENABLE_V2] = booleanToString(isEnableV2)
        return args
    }

    enum class Type {
        APPLICATION,
        LIBRARY,
        FEATURE
    }

    companion object {
        private const val PREFIX = "android.databinding."
        private const val PARAM_ARTIFACT_TYPE = PREFIX + "artifactType"
        private const val PARAM_MODULE_PACKAGE = PREFIX + "modulePackage"
        private const val PARAM_MIN_API = PREFIX + "minApi"
        private const val PARAM_SDK_DIR = PREFIX + "sdkDir"
        private const val PARAM_BUILD_DIR = PREFIX + "buildDir"
        private const val PARAM_LAYOUT_INFO_DIR = PREFIX + "layoutInfoDir"
        private const val PARAM_CLASS_LOG_DIR = PREFIX + "classLogDir"
        private const val PARAM_BASE_FEATURE_INFO_DIR = PREFIX + "baseFeatureInfoDir"
        private const val PARAM_FEATURE_INFO_DIR = PREFIX + "featureInfoDir"
        private const val PARAM_AAR_OUT_DIR = PREFIX + "aarOutDir"
        private const val PARAM_EXPORT_CLASS_LIST_OUT_FILE = PREFIX + "exportClassListOutFile"
        private const val PARAM_ENABLE_DEBUG_LOGS = PREFIX + "enableDebugLogs"
        private const val PARAM_PRINT_ENCODED_ERROR_LOGS = PREFIX + "printEncodedErrorLogs"
        private const val PARAM_IS_TEST_VARIANT = PREFIX + "isTestVariant"
        private const val PARAM_ENABLE_FOR_TESTS = PREFIX + "enableForTests"
        private const val PARAM_ENABLE_V2 = PREFIX + "enableV2"

        @JvmField
        val ALL_PARAMS: Set<String> = Sets.newHashSet(
            PARAM_ARTIFACT_TYPE,
            PARAM_MODULE_PACKAGE,
            PARAM_MIN_API,
            PARAM_SDK_DIR,
            PARAM_BUILD_DIR,
            PARAM_LAYOUT_INFO_DIR,
            PARAM_CLASS_LOG_DIR,
            PARAM_BASE_FEATURE_INFO_DIR,
            PARAM_FEATURE_INFO_DIR,
            PARAM_AAR_OUT_DIR,
            PARAM_EXPORT_CLASS_LIST_OUT_FILE,
            PARAM_ENABLE_DEBUG_LOGS,
            PARAM_PRINT_ENCODED_ERROR_LOGS,
            PARAM_IS_TEST_VARIANT,
            PARAM_ENABLE_FOR_TESTS,
            PARAM_ENABLE_V2
        )

        @JvmStatic
        fun readFromOptions(options: Map<String, String>): CompilerArguments {
            return CompilerArguments(
                artifactType = Type.valueOf(options[PARAM_ARTIFACT_TYPE]!!),
                modulePackage = options[PARAM_MODULE_PACKAGE]!!,
                minApi = Integer.parseInt(options[PARAM_MIN_API]!!),
                sdkDir = File(options[PARAM_SDK_DIR]!!),
                buildDir = File(options[PARAM_BUILD_DIR]!!),
                layoutInfoDir = File(options[PARAM_LAYOUT_INFO_DIR]!!),
                classLogDir = File(options[PARAM_CLASS_LOG_DIR]!!),
                baseFeatureInfoDir = options[PARAM_BASE_FEATURE_INFO_DIR]?.let { File(it) },
                featureInfoDir = options[PARAM_FEATURE_INFO_DIR]?.let { File(it) },
                aarOutDir = options[PARAM_AAR_OUT_DIR]?.let { File(it) },
                exportClassListOutFile = options[PARAM_EXPORT_CLASS_LIST_OUT_FILE]?.let { File(it) },
                enableDebugLogs = stringToBoolean(options[PARAM_ENABLE_DEBUG_LOGS]),
                printEncodedErrorLogs =
                stringToBoolean(options[PARAM_PRINT_ENCODED_ERROR_LOGS]),
                isTestVariant = stringToBoolean(options[PARAM_IS_TEST_VARIANT]),
                isEnabledForTests = stringToBoolean(options[PARAM_ENABLE_FOR_TESTS]),
                isEnableV2 = stringToBoolean(options[PARAM_ENABLE_V2])
            )
        }

        private fun booleanToString(boolValue: Boolean): String {
            return if (boolValue) "1" else "0"
        }

        private fun stringToBoolean(boolValue: String?): Boolean {
            return boolValue?.trim() == "1"
        }
    }
}
