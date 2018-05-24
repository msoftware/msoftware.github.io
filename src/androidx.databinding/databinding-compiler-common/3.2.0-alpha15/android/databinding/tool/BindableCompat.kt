/*
 * Copyright (C) 2018 The Android Open Source Project
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

import java.lang.reflect.Field
import java.lang.reflect.Method
import javax.lang.model.element.Element

/**
 * Wrapper class when accessing Bindable annotation that handles both androidx and support namespaces
 */
class BindableCompat(val dependencies : Array<String>) {
    companion object {
        private val SUPPORT =  android.databinding.Bindable::class.java
        private val ANDROID_X = androidx.databinding.Bindable::class.java
        @JvmStatic
        fun extractFrom(element : Element) : BindableCompat? {
            return extractSupport(element) ?: extractAndroidX(element)
        }

        @JvmStatic
        fun extractFrom(method : Method) : BindableCompat? {
            return extractSupport(method) ?: extractAndroidX(method)
        }

        @JvmStatic
        fun extractFrom(field : Field) : BindableCompat? {
            return extractSupport(field) ?: extractAndroidX(field)
        }

        private fun extractAndroidX(element: Element): BindableCompat? {
            return element.getAnnotation(ANDROID_X)?.toCompat()
        }

        private fun extractSupport(element: Element): BindableCompat? {
            return element.getAnnotation(SUPPORT)?.toCompat()
        }

        private fun extractAndroidX(method: Method): BindableCompat? {
            return method.getAnnotation(ANDROID_X)?.toCompat()
        }

        private fun extractSupport(method : Method): BindableCompat? {
            return method.getAnnotation(SUPPORT)?.toCompat()
        }

        private fun extractAndroidX(field: Field): BindableCompat? {
            return field.getAnnotation(ANDROID_X)?.toCompat()
        }

        private fun extractSupport(field: Field): BindableCompat? {
            return field.getAnnotation(SUPPORT)?.toCompat()
        }

        private fun android.databinding.Bindable.toCompat() = BindableCompat(value)

        private fun androidx.databinding.Bindable.toCompat() = BindableCompat(value)
    }
}