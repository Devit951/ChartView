package com.github.chartslib

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class ChartView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0): View(context, attrs, defStyle) {

    var data = intArrayOf()
        set(value){
            field = value
            invalidate()
        }

    var padding = 0f
        set(value){
            field = dp2Px(value)
            invalidate()
        }

    var chart: Chart = VerticalChart()
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (data.isNotEmpty()){
            val maxDataVal = data.max()!!
            val sizeOfChart = chart.sizeOfChart(canvas, data.size)
            data.forEachIndexed { index, item ->
                chart.draw(sizeOfChart, index, item, maxDataVal, padding, canvas)
            }
        }
    }

    private fun dp2Px(dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }
}