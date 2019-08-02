package com.github.chartslib

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF

class VerticalChart(chartColor: Int = Color.parseColor("#db8f75")): Chart{

    private val chartPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = chartColor
    }

    override fun draw(sizeOfChart: Float, index: Int, item: Int, maxDataVal: Int, padding: Float, canvas: Canvas) {
        val height = canvas.height
        val bottom = height.toFloat()
        val chartRect = RectF(
            sizeOfChart * index.toFloat() + padding,
            height - height * (item / maxDataVal.toFloat()) + padding,
            sizeOfChart * (index.toFloat() + 1) - padding,
            bottom - padding
        )
        canvas.drawRect(chartRect, chartPaint)
    }

    override fun sizeOfChart(canvas: Canvas, totalChartCount: Int): Float {
        return canvas.width / totalChartCount.toFloat()
    }
}