package com.github.devit951

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.github.chartslib.ChartView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ChartView(this).apply {
            padding = 4f
            data = intArrayOf(500, 250, 1000, 100, 720, 570, 375, 125, 888, 270)
        })
    }
}
