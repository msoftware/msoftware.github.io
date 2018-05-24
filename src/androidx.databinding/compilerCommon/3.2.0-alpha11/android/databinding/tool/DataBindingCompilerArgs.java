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

package android.databinding.tool;

import com.android.annotations.Nullable;

import com.google.common.collect.Sets;

import android.databinding.tool.util.Preconditions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This class is used to pass information from the build system into the data binding compiler.
 * It can serialize itself to a given list of annotation processor options and read itself
 * from there.
 */
@SuppressWarnings("unused")
public class DataBindingCompilerArgs {
    private static final String PREFIX = "android.databinding.";
    // the folder used by data binding to read / write data about the build process
    private static final String PARAM_BUILD_FOLDER = PREFIX + "bindingBuildFolder";

    // the folder where generational class files are exported, only set in library builds
    private static final String PARAM_AAR_OUT_FOLDER = PREFIX + "generationalFileOutDir";

    private static final String PARAM_SDK_DIR = PREFIX + "sdkDir";

    private static final String PARAM_ARTIFACT_TYPE = PREFIX + "artifactType";

    private static final String PARAM_XML_OUT_DIR = PREFIX + "xmlOutDir";

    private static final String PARAM_EXPORT_CLASS_LIST_TO = PREFIX + "exportClassListTo";

    private static final String PARAM_MODULE_PKG = PREFIX + "modulePackage";

    private static final String PARAM_MIN_API = PREFIX + "minApi";

    private static final String PARAM_ENABLE_DEBUG_LOGS = PREFIX + "enableDebugLogs";

    private static final String PARAM_PRINT_ENCODED_ERROR_LOGS = PREFIX + "printEncodedErrors";

    private static final String PARAM_IS_TEST_VARIANT = PREFIX + "isTestVariant";

    private static final String PARAM_ENABLE_FOR_TESTS = PREFIX + "enableForTests";

    private static final String PARAM_ENABLE_V2 = PREFIX + "enableV2";

    private static final String PARAM_CLASS_LOG_DIR = PREFIX + "classLogFile";

    private static final String PARAM_BASE_FEATURE_INFO = PREFIX + "baseFeatureInfo";

    private static final String PARAM_FEATURE_INFO = PREFIX + "featureInfo";

    public static final Set<String> ALL_PARAMS = Sets.newHashSet(PARAM_BUILD_FOLDER,
            PARAM_AAR_OUT_FOLDER, PARAM_SDK_DIR, PARAM_ARTIFACT_TYPE, PARAM_XML_OUT_DIR,
            PARAM_EXPORT_CLASS_LIST_TO, PARAM_MODULE_PKG, PARAM_MIN_API,
            PARAM_ENABLE_DEBUG_LOGS, PARAM_PRINT_ENCODED_ERROR_LOGS, PARAM_IS_TEST_VARIANT,
            PARAM_ENABLE_FOR_TESTS, PARAM_ENABLE_V2, PARAM_CLASS_LOG_DIR,
            PARAM_BASE_FEATURE_INFO, PARAM_FEATURE_INFO);

    private String mBuildFolder;
    private String mAarOutFolder;
    private String mSdkDir;
    private String mXmlOutDir;
    private String mExportClassListTo;
    private String mModulePackage;
    private String mClassLogDir;
    // set when compiling a base feature, includes the package ids of all features
    private String mBaseFeatureInfoFolder;
    // set when compiling a feature, includes the features id offset as well as the BR files it
    // is responsible to generate
    private String mFeatureInfo;
    private int mMinApi;
    private Type mArtifactType;
    private boolean mIsTestVariant;
    private boolean mEnableDebugLogs;
    private boolean mPrintEncodedErrorLogs;
    private boolean mEnabledForTests;
    private boolean mEnableV2;

    private DataBindingCompilerArgs() {
    }

    public static DataBindingCompilerArgs readFromOptions(Map<String, String> options) {
        DataBindingCompilerArgs args = new DataBindingCompilerArgs();
        args.mBuildFolder = options.get(PARAM_BUILD_FOLDER);
        args.mAarOutFolder = options.get(PARAM_AAR_OUT_FOLDER);
        args.mSdkDir = options.get(PARAM_SDK_DIR);
        args.mXmlOutDir = options.get(PARAM_XML_OUT_DIR);
        args.mExportClassListTo = options.get(PARAM_EXPORT_CLASS_LIST_TO);
        args.mModulePackage = options.get(PARAM_MODULE_PKG);
        args.mClassLogDir = options.get(PARAM_CLASS_LOG_DIR);
        args.mMinApi = Integer.parseInt(options.get(PARAM_MIN_API));
        args.mBaseFeatureInfoFolder = options.get(PARAM_BASE_FEATURE_INFO);
        args.mFeatureInfo = options.get(PARAM_FEATURE_INFO);
        // use string for artifact type, easier to read
        String artifactType = options.get(PARAM_ARTIFACT_TYPE);
        Type buildType = Type.valueOf(artifactType);
        args.mArtifactType = buildType;
        args.mEnableDebugLogs = deserialize(options.get(PARAM_ENABLE_DEBUG_LOGS));
        args.mPrintEncodedErrorLogs = deserialize(options.get(PARAM_PRINT_ENCODED_ERROR_LOGS));
        args.mIsTestVariant = deserialize(options.get(PARAM_IS_TEST_VARIANT));
        args.mEnabledForTests = deserialize(options.get(PARAM_ENABLE_FOR_TESTS));
        args.mEnableV2 = deserialize(options.get(PARAM_ENABLE_V2));
        return args;
    }

    @Nullable
    public String getBuildFolder() {
        return mBuildFolder;
    }

    @Nullable
    public String getAarOutFolder() {
        return mAarOutFolder;
    }

    public String getSdkDir() {
        return mSdkDir;
    }

    public String getXmlOutDir() {
        return mXmlOutDir;
    }

    public String getExportClassListTo() {
        return mExportClassListTo;
    }

    public String getModulePackage() {
        return mModulePackage;
    }

    public Type artifactType() {
        return mArtifactType;
    }

    public String getClassLogDir() {
        return mClassLogDir;
    }

    public String getBaseFeatureInfoFolder() {
        return mBaseFeatureInfoFolder;
    }

    public String getFeatureInfoFolder() {
        return mFeatureInfo;
    }

    public boolean isTestVariant() {
        return mIsTestVariant;
    }

    public boolean isLibrary() {
        return mArtifactType == Type.LIBRARY;
    }

    public boolean isApp() {
        return mArtifactType == Type.APPLICATION;
    }

    public boolean isFeature() {
        return mArtifactType == Type.FEATURE;
    }

    public boolean enableDebugLogs() {
        return mEnableDebugLogs;
    }

    public boolean shouldPrintEncodedErrorLogs() {
        return mPrintEncodedErrorLogs;
    }

    public int getMinApi() {
        return mMinApi;
    }

    public boolean isEnabledForTests() {
        return mEnabledForTests;
    }

    public boolean isEnableV2() {
        return mEnableV2;
    }

    public Map<String, String> toMap() {
        Map<String, String> args = new HashMap<>();
        putIfNotNull(mBuildFolder, args, PARAM_BUILD_FOLDER, mBuildFolder);
        putIfNotNull(mAarOutFolder, args, PARAM_AAR_OUT_FOLDER, mAarOutFolder);
        putIfNotNull(mSdkDir, args, PARAM_SDK_DIR, mSdkDir);
        putIfNotNull(mXmlOutDir, args, PARAM_XML_OUT_DIR, mXmlOutDir);
        putIfNotNull(mExportClassListTo, args, PARAM_EXPORT_CLASS_LIST_TO, mExportClassListTo);
        putIfNotNull(mModulePackage, args, PARAM_MODULE_PKG, mModulePackage);
        putIfNotNull(mClassLogDir, args, PARAM_CLASS_LOG_DIR, mClassLogDir);
        putIfNotNull(mBaseFeatureInfoFolder, args, PARAM_BASE_FEATURE_INFO,
                mBaseFeatureInfoFolder);
        putIfNotNull(mFeatureInfo, args, PARAM_FEATURE_INFO, mFeatureInfo);
        args.put(PARAM_MIN_API, String.valueOf(mMinApi));
        putIfNotNull(mArtifactType, args, PARAM_ARTIFACT_TYPE, mArtifactType.name());
        args.put(PARAM_ENABLE_DEBUG_LOGS, serialize(mEnableDebugLogs));
        args.put(PARAM_PRINT_ENCODED_ERROR_LOGS, serialize(mPrintEncodedErrorLogs));
        args.put(PARAM_IS_TEST_VARIANT, serialize(mIsTestVariant));
        args.put(PARAM_ENABLE_FOR_TESTS, serialize(mEnabledForTests));
        args.put(PARAM_ENABLE_V2, serialize(mEnableV2));
        return args;
    }

    /**
     * Creates a copy of the arguments but sets th version to v1 and package to the given package.
     * This is used when we need to run a compatibility compilation for v1 dependencies.
     */
    public DataBindingCompilerArgs copyAsV1(String modulePackage) {
        Map<String, String> asMap = toMap();
        asMap.put(PARAM_ENABLE_V2, serialize(false));
        asMap.put(PARAM_MODULE_PKG, modulePackage);
        return readFromOptions(asMap);
    }

    private static void putIfNotNull(Object data, Map<String, String> map, String key,
            String value) {
        if (data != null) {
            map.put(key, value);
        }
    }

    private static String serialize(boolean boolValue) {
        return boolValue ? "1" : "0";
    }

    private static boolean deserialize(String boolValue) {
        return boolValue != null && "1".equals(boolValue.trim());
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private File mBuildFolder;
        private File mBundleFolder;
        private File mSdkDir;
        private File mXmlOutDir;
        private File mExportClassListTo;
        private File mClassLogDir;
        private String mModulePackage;
        private File mBaseFeatureInfoFolder;
        private File mFeatureInfoFolder;
        private Type mType;
        private Integer mMinApi;
        private boolean mEnableDebugLogs;
        private boolean mPrintEncodedErrorLogs;
        private boolean mIsTestVariant;
        private boolean mEnabledForTests;
        private boolean mEnableV2;

        private Builder() {
        }

        public Builder buildFolder(File buildFolder) {
            mBuildFolder = buildFolder;
            return this;
        }

        public Builder modulePackage(String modulePackage) {
            mModulePackage = modulePackage;
            return this;
        }

        public Builder bundleFolder(File bundleFolder) {
            mBundleFolder = bundleFolder;
            return this;
        }

        public Builder sdkDir(File sdkDir) {
            mSdkDir = sdkDir;
            return this;
        }

        public Builder xmlOutDir(File xmlOutDir) {
            mXmlOutDir = xmlOutDir;
            return this;
        }

        public Builder baseFeatureInfoFolder(File baseFeatureInfoFolder) {
            mBaseFeatureInfoFolder = baseFeatureInfoFolder;
            return this;
        }

        public Builder featureInfoFolder(File featureInfoFolder) {
            mFeatureInfoFolder = featureInfoFolder;
            return this;
        }

        public Builder classLogDir(File classLogDir) {
            mClassLogDir = classLogDir;
            return this;
        }

        public Builder exportClassListTo(@Nullable File exportClassListTo) {
            mExportClassListTo = exportClassListTo;
            return this;
        }

        public Builder enableDebugLogs(boolean enableDebugLogs) {
            mEnableDebugLogs = enableDebugLogs;
            return this;
        }

        public Builder type(Type type) {
            mType = type;
            return this;
        }

        public Builder printEncodedErrorLogs(boolean printEncodedErrorLogs) {
            mPrintEncodedErrorLogs = printEncodedErrorLogs;
            return this;
        }

        public Builder minApi(int minApi) {
            mMinApi = minApi;
            return this;
        }

        public Builder testVariant(boolean testVariant) {
            mIsTestVariant = testVariant;
            return this;
        }

        public Builder enabledForTests(boolean enabledForTests) {
            mEnabledForTests = enabledForTests;
            return this;
        }

        public Builder enableV2(boolean enableV2) {
            mEnableV2 = enableV2;
            return this;
        }

        public DataBindingCompilerArgs build() {
            DataBindingCompilerArgs args = new DataBindingCompilerArgs();
            Preconditions.checkNotNull(mType, "Must specify type of the build. Lib or App or Test?"
                    + " or not");
            args.mArtifactType = mType;

            Preconditions.checkNotNull(mBuildFolder, "Must provide the build folder for data "
                    + "binding");
            args.mBuildFolder = mBuildFolder.getAbsolutePath();

            Preconditions.checkNotNull(mSdkDir, "Must provide sdk directory");
            args.mSdkDir = mSdkDir.getAbsolutePath();

            Preconditions.checkNotNull(mXmlOutDir, "Must provide xml out directory");
            args.mXmlOutDir = mXmlOutDir.getAbsolutePath();

            Preconditions.checkNotNull(mClassLogDir, "Must provide class log directory");
            args.mClassLogDir = mClassLogDir.getAbsolutePath();

            Preconditions.check(mType != Type.LIBRARY || mIsTestVariant
                            || mBundleFolder != null,
                    "Must specify bundle folder (aar out folder) for library projects");
            args.mAarOutFolder = mBundleFolder.getAbsolutePath();

            Preconditions.check(mType != Type.LIBRARY || mIsTestVariant
                            || mExportClassListTo != null,
                    "Must provide a folder to export generated class list");

            Preconditions.checkNotNull(mModulePackage, "Must provide a module package");
            args.mModulePackage = mModulePackage;

            if (args.mArtifactType == Type.FEATURE) {
                Preconditions.check(mFeatureInfoFolder != null, "must provide" +
                        " a feature info folder while compiling a non-base feature module");
            }

            args.mBaseFeatureInfoFolder = mBaseFeatureInfoFolder == null ? null :
                    mBaseFeatureInfoFolder.getAbsolutePath();
            args.mFeatureInfo = mFeatureInfoFolder == null ? null :
                    mFeatureInfoFolder.getAbsolutePath();


            Preconditions.checkNotNull(mMinApi, "Must provide the min api for the project");
            args.mMinApi = mMinApi;
            if (mExportClassListTo != null) {
                args.mExportClassListTo = mExportClassListTo.getAbsolutePath();
            }
            args.mEnableDebugLogs = mEnableDebugLogs;
            args.mPrintEncodedErrorLogs = mPrintEncodedErrorLogs;
            args.mIsTestVariant = mIsTestVariant;
            args.mEnabledForTests = mEnabledForTests;
            args.mEnableV2 = mEnableV2;
            return args;
        }
    }

    public enum Type {
        LIBRARY,
        APPLICATION,
        FEATURE
    }
}
