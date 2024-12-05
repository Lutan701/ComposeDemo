package com.demo.xx.model

import android.util.Log
import javax.inject.Inject

class BarrelModel @Inject constructor() {

    fun getBarrelsStatus(): List<Int> {
        val states = listOf(2, 2, 3)
        Log.e("BarrelModel", "getBarrelsStatus: $states")
        return states
    }

}