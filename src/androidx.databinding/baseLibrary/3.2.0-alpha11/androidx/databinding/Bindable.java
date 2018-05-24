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

import androidx.databinding.Observable.OnPropertyChangedCallback;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Bindable annotation should be applied to any getter accessor method of an
 * {@link Observable} class. Bindable will generate a field in the BR class to identify
 * the field that has changed.
 * <p>
 * When applied to an accessor method, the Bindable annotation takes an optional
 * list of property names that it depends on. If there is a change notification of any of the
 * listed properties, this value will also be considered dirty and be refreshed. For example:
 * <p><pre>
 * <code>&commat;Bindable
 * public void getFirstName() { return this.firstName; }
 *
 * &commat;Bindable
 * public void getLastName() { return this.lastName; }
 *
 * &commat;Bindable({"firstName", "lastName"}}
 * public void getName() { return this.firstName + ' ' + this.lastName; }
 * </code></pre>
 * <p>
 * Whenever either {@code firstName} or {@code lastName} has a change notification, {@code name}
 * will also be considered dirty. This does not mean that
 * {@link OnPropertyChangedCallback#onPropertyChanged(Observable, int)} will be notified for
 * {@code BR.name}, only that binding expressions containing {@code name} will be dirtied and
 * refreshed.
 *
 * @see OnPropertyChangedCallback#onPropertyChanged(Observable, int)
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) // this is necessary for java analyzer to work
public @interface Bindable {
    String[] value() default  {};
}
