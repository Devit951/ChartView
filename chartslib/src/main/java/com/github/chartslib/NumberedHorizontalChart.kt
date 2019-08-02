package com.github.chartslib

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class NumberedHorizontalChart(private val horizontalChart: HorizontalChart,
                              private val initPaint: (Paint.() -> Unit)? = null): Chart{

    private val textSize = 30f

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLUE
        textSize = this@NumberedHorizontalChart.textSize
        initPaint?.invoke(this)
    }

    override fun draw(sizeOfChart: Float, index: Int, item: Int, maxDataVal: Int, padding: Float, canvas: Canvas) {
        canvas.save()
        canvas.translate(canvas.width * 0.09f, 0f)
        canvas.scale(0.91f, 1f)
        horizontalChart.draw(sizeOfChart, index, item, maxDataVal, padding, canvas)
        canvas.restore()

        canvas.drawText(item.toString(), padding, sizeOfChart * (index + 1) + padding - (sizeOfChart / 2), textPaint)
    }

    override fun sizeOfChart(canvas: Canvas, totalChartCount: Int) = horizontalChart.sizeOfChart(canvas, totalChartCount)
}