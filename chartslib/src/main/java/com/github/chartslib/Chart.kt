package com.github.chartslib

import android.graphics.Canvas

interface Chart {
    fun draw(sizeOfChart: Float,
             index: Int,
             item: Int,
             maxDataVal: Int,
             padding: Float,
             canvas: Canvas)

    fun sizeOfChart(canvas: Canvas, totalChartCount: Int): Float
}