package com.github.chartslib

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class NumberedVerticalChart(private val verticalChart: VerticalChart,
                            private val rotationDegree: Float = -45f,
                            initPaint: (Paint.() -> Unit)? = null): Chart {

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        textSize = 30f
        initPaint?.invoke(this)
    }

    override fun draw(sizeOfChart: Float, index: Int, item: Int, maxDataVal: Int, padding: Float, canvas: Canvas) {
        val height = canvas.height
        canvas.save()
        canvas.scale(1f, 0.95f)
        verticalChart.draw(sizeOfChart, index, item, maxDataVal, padding, canvas)
        canvas.restore()
        val x = sizeOfChart * index.toFloat() + sizeOfChart / 4f
        val y = height.toFloat() - height * 0.05f / 2
        canvas.save()
        canvas.rotate(rotationDegree, x + padding, y - padding)
        canvas.drawText(
            item.toString(),
            x,
            y + padding + padding / 2,
            textPaint
        )
        canvas.restore()
    }

    override fun sizeOfChart(canvas: Canvas, totalChartCount: Int) = verticalChart.sizeOfChart(canvas, totalChartCount)
}