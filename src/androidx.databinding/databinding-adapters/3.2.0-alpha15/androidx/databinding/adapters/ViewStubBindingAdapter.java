/*
 * Copyright (C) 2015 The Android Open Source Project
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
package androidx.databinding.adapters;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.Untaggable;
import androidx.databinding.ViewStubProxy;
import androidx.annotation.RestrictTo;
import android.view.ViewStub.OnInflateListener;

/**
 * @hide
 */
@RestrictTo(RestrictTo.Scope.LIBRARY)
@Untaggable({"android.view.ViewStub"})
@BindingMethods({
        @BindingMethod(type = android.view.ViewStub.class, attribute = "android:layout", method = "setLayoutResource")
})
public class ViewStubBindingAdapter {
    @BindingAdapter("android:onInflate")
    public static void setOnInflateListener(ViewStubProxy viewStubProxy,
            OnInflateListener listener) {
        viewStubProxy.setOnInflateListener(listener);
    }
}
