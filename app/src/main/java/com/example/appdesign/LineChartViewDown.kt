package com.example.appdesign

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

class LineChartViewDown(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val linePaint = Paint().apply {
        color = resources.getColor(R.color.fff)
        strokeWidth = 5f
        style = Paint.Style.STROKE
        isAntiAlias = true
    }

    private val gradientPaint = Paint().apply {
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    private var dataPoints: List<Float> = listOf()

    private val dpToPx: Float
        get() = Resources.getSystem().displayMetrics.density

    private val pointOffset = 3 * dpToPx

    fun setData(points: List<Float>) {
        dataPoints = points
        invalidate()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (dataPoints.isEmpty()) return

        val width = width.toFloat() - 2 * pointOffset
        val height = height.toFloat() - 2 * pointOffset

        val spacing = width / (dataPoints.size - 1)

        val maxValue = dataPoints.maxOrNull() ?: 3f
        val minValue = dataPoints.minOrNull() ?: 2f
        val valueRange = (maxValue - minValue).takeIf { it > 0 } ?: 1f

        val path = Path()
        path.moveTo(pointOffset, height + pointOffset)

        for (i in dataPoints.indices) {
            val x = i * spacing + pointOffset
            val y = height - ((dataPoints[i] - minValue) / valueRange * height) + pointOffset
            path.lineTo(x, y)
        }

        path.lineTo(width + pointOffset, height + pointOffset)
        path.close()

        val gradient = LinearGradient(
            0f, 0f, 0f, height + 2 * pointOffset,
            Color.parseColor("#1AFA4347"),
            Color.parseColor("#00FA4347"),
            Shader.TileMode.CLAMP
        )
        gradientPaint.shader = gradient

        canvas.drawPath(path, gradientPaint)

        for (i in 0 until dataPoints.size - 1) {
            val x1 = i * spacing + pointOffset
            val y1 = height - ((dataPoints[i] - minValue) / valueRange * height) + pointOffset
            val x2 = (i + 1) * spacing + pointOffset
            val y2 = height - ((dataPoints[i + 1] - minValue) / valueRange * height) + pointOffset

            canvas.drawLine(x1, y1, x2, y2, linePaint)
        }
    }
}