package com.github.chartslib

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class ChartView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0): View(context, attrs, defStyle) {

    private val chartPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#db8f75")
    }

    private val textPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.BLACK
        textSize = 30f
    }

    var data = intArrayOf()
        set(value){
            field = value
            invalidate()
        }

    var padding = 0
        set(value){
            field = value
            invalidate()
        }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (data.isNotEmpty()){
            val maxDataVal = data.max()!!
            val widthOfChart = width / data.size
            data.forEachIndexed { index, item ->
                drawChart(widthOfChart, index, item, maxDataVal, canvas)
                drawNumber(widthOfChart, index, item, canvas)
            }
        }
    }

    private fun drawChart(widthOfChart: Int, index: Int, item: Int, maxDataVal: Int, canvas: Canvas) {
        val bottom = height.toFloat() - height * 0.05f
        val chartRect = RectF(
            widthOfChart * index.toFloat() + padding,
            height - height * (item / maxDataVal.toFloat()) + padding,
            widthOfChart * (index.toFloat() + 1) - padding,
            bottom - padding
        )
        canvas.drawRect(chartRect, chartPaint)
    }


    private fun drawNumber(widthOfChart: Int, index: Int, item: Int, canvas: Canvas) {
        canvas.save()
        val x = widthOfChart * index.toFloat() + widthOfChart / 4f
        val y = height.toFloat() - height * 0.05f / 2
        canvas.rotate(-45f, x + padding, y - padding)
        canvas.drawText(
            item.toString(),
            x,
            y + padding + padding / 2,
            textPaint
        )
        canvas.restore()
    }
}