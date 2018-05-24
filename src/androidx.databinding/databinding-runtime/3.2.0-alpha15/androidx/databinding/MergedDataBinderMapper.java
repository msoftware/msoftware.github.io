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

package androidx.databinding;


import android.view.View;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * A data binding mapper that merges other mappers.
 */
@SuppressWarnings("unused")
public class MergedDataBinderMapper extends DataBinderMapper {
    private List<DataBinderMapper> mMappers = new CopyOnWriteArrayList<>();
    /**
     * List of features that have binding mappers. We try to load those classes lazily when we
     * cannot find a binding.
     */
    private List<String> mFeatureBindingMappers = new CopyOnWriteArrayList<>();

    @SuppressWarnings("WeakerAccess")
    protected void addMapper(DataBinderMapper mapper) {
        mMappers.add(mapper);
    }

    @SuppressWarnings({"WeakerAccess", "unused"})
    protected void addMapper(String featureMapper) {
        mFeatureBindingMappers.add(featureMapper + ".DataBinderMapperImpl");
    }

    @Override
    public ViewDataBinding getDataBinder(DataBindingComponent bindingComponent, View view,
            int layoutId) {
        for(DataBinderMapper mapper : mMappers) {
            ViewDataBinding result = mapper.getDataBinder(bindingComponent, view, layoutId);
            if (result != null) {
                return result;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(bindingComponent, view, layoutId);
        }
        return null;
    }

    @Override
    public ViewDataBinding getDataBinder(DataBindingComponent bindingComponent, View[] view,
            int layoutId) {
        for(DataBinderMapper mapper : mMappers) {
            ViewDataBinding result = mapper.getDataBinder(bindingComponent, view, layoutId);
            if (result != null) {
                return result;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(bindingComponent, view, layoutId);
        }
        return null;
    }

    @Override
    public int getLayoutId(String tag) {
        for(DataBinderMapper mapper : mMappers) {
            int result = mapper.getLayoutId(tag);
            if (result != 0) {
                return result;
            }
        }
        if (loadFeatures()) {
            return getLayoutId(tag);
        }
        return 0;
    }

    @Override
    public String convertBrIdToString(int id) {
        for(DataBinderMapper mapper : mMappers) {
            String result = mapper.convertBrIdToString(id);
            if (result != null) {
                return result;
            }
        }
        if (loadFeatures()) {
            return convertBrIdToString(id);
        }
        return null;
    }

    /**
     * @return true if we load a new mapper
     */
    private boolean loadFeatures() {
        boolean found = false;
        for (String mapper : mFeatureBindingMappers) {
            try {
                Class<?> aClass = Class.forName(mapper);
                if (DataBinderMapper.class.isAssignableFrom(aClass)) {
                    DataBinderMapper featureMapper = (DataBinderMapper) aClass.newInstance();
                    addMapper(featureMapper);
                    mFeatureBindingMappers.remove(mapper);
                    found = true;
                }

            } catch (ClassNotFoundException ignored) {
            } catch (IllegalAccessException ignored) {
            } catch (InstantiationException ignored) {
            }
        }
        return found;
    }
}
