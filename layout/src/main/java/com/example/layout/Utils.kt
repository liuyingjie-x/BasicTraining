package com.example.layout

import android.content.res.Resources
import android.util.TypedValue

public class Utils {
    companion object {
        public fun dpToPixel(dp: Float): Float {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, dp,
                Resources.getSystem().displayMetrics
            )
        }
    }
}