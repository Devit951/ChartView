package com.github.chartslib

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class HorizontalChart(chartColor: Int = Color.parseColor("#db8f75")): Chart {

    private val chartPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = chartColor
    }

    override fun draw(sizeOfChart: Float, index: Int, item: Int, maxDataVal: Int, padding: Float, canvas: Canvas) {
        val width = canvas.width
        val chartRect = RectF(
            0f,
            sizeOfChart * index + padding,
            width * (item / maxDataVal.toFloat()) - padding,
            sizeOfChart * (index + 1) * 1f - padding
        )
        canvas.drawRect(chartRect, chartPaint)
    }

    override fun sizeOfChart(canvas: Canvas, totalChartCount: Int) = canvas.height / totalChartCount.toFloat()
}