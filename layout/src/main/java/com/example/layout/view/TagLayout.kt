package com.example.layout.view

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.ViewGroup
import java.util.*

class TagLayout @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ViewGroup(context, attrs, defStyleAttr) {
    private var childrenBounds: MutableList<Rect> = mutableListOf()
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var widthUsed = 0
        var heightUsed = 0
        var lineWidthUsed = 0
        var lineMaxHeight = 0
        val specMode = MeasureSpec.getMode(widthMeasureSpec)
        val specWidth = MeasureSpec.getSize(widthMeasureSpec)
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            if (specMode != MeasureSpec.UNSPECIFIED &&
                lineWidthUsed + child.measuredWidth > specWidth
            ) {
                lineWidthUsed = 0
                heightUsed += lineMaxHeight
                lineMaxHeight = 0
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed)
            }
            var childBound: Rect
            if (childrenBounds.size <= i) {
                childBound = Rect()
                childrenBounds.add(childBound)
            } else {
                childBound = childrenBounds[i]
            }
            childBound[lineWidthUsed, heightUsed, lineWidthUsed + child.measuredWidth] =
                heightUsed + child.measuredHeight
            lineWidthUsed += child.measuredWidth
            widthUsed = widthUsed.coerceAtLeast(lineWidthUsed)
            lineMaxHeight = lineMaxHeight.coerceAtLeast(child.measuredHeight)
        }

        val width = widthUsed
        val height = heightUsed + lineMaxHeight
        setMeasuredDimension(width, height)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            val childBounds = childrenBounds[i]
            child.layout(childBounds.left, childBounds.top, childBounds.right, childBounds.bottom)
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)    }
}