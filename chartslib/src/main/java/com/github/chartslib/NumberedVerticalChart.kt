package com.github.chartslib

import android.graphics.*

class NumberedVerticalChart(private val verticalChart: VerticalChart,
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
        val textBound = Rect()
        textPaint.getTextBounds(item.toString(), 0, item.toString().length, textBound)
        val x = sizeOfChart * (index.toFloat() + 1) - padding - (sizeOfChart / 2f) - (textBound.right / 2f)
        val y = height.toFloat() - height * 0.05f + (height * 0.05f  / 2f)
        canvas.drawText(
            item.toString(),
            x,
            y,
            textPaint
        )
    }

    override fun sizeOfChart(canvas: Canvas, totalChartCount: Int) = verticalChart.sizeOfChart(canvas, totalChartCount)
}