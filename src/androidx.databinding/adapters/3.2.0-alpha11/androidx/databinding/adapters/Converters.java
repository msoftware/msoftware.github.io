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

import androidx.databinding.BindingConversion;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;

/**
 * Build in converters to converts for color.
 */
public class Converters {
    /**
     * Converts {@code int} color into a {@link ColorDrawable}.
     *
     * @param color The integer representation of the color.
     *
     * @return ColorDrawable matching the color
     */
    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }

    /**
     * Converts {@code int} color into a {@link ColorStateList}.
     *
     * @param color The integer representation of the color.
     *
     * @return ColorStateList from the single color
     */
    @BindingConversion
    public static ColorStateList convertColorToColorStateList(int color) {
        return ColorStateList.valueOf(color);
    }
}
