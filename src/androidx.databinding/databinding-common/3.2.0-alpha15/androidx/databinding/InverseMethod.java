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

package androidx.databinding;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The InverseMethod annotation may be applied to any method used in two-way data binding
 * to declare the method used to invert the call when going from the View's attribute
 * value to the bound data value. The inverse method must take the same number of parameters
 * and only the final parameter type may differ. The final parameter of this method must match
 * the return value of its inverse and the return value of this method must match the final
 * parameter of its inverse.
 * <p><pre>
 * <code>&commat;InverseMethod("convertIntToString")
 * public static int convertStringToInt(String value) {
 *     try {
 *         return Integer.parseInt(value);
 *     } catch (NumberFormatException e) {
 *         return -1;
 *     }
 * }
 *
 * public static String convertIntToString(int value) {
 *     return String.valueOf(value);
 * }
 * </code></pre>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // this is necessary for java analyzer to work
public @interface InverseMethod {
    /**
     * @return The name of the method on this class to use as the inverse.
     */
    String value();
}
