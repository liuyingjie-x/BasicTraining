package com.example.layout.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.example.layout.Utils

class CircleView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    var paint = Paint(Paint.ANTI_ALIAS_FLAG)

    companion object {
        val PADDING = Utils.dpToPixel(30f)
        val RADIUS = Utils.dpToPixel(20f)

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        var width = ((PADDING + RADIUS) * 2).toInt()
        var height = ((PADDING + RADIUS) * 2).toInt()

        width = resolveSizeAndState(width, widthMeasureSpec, 0)
        height = resolveSizeAndState(height, widthMeasureSpec, 0)
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.RED)
        canvas?.drawCircle(PADDING + RADIUS, PADDING + RADIUS, RADIUS, paint)


    }
}