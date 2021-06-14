package com.example.layout.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import kotlin.math.max

class SquareView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val height = measuredHeight
        val width = measuredWidth
        val size = max(height, width)
        setMeasuredDimension(size, size)
    }
}