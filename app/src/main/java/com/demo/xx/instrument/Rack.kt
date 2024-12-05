package com.demo.xx.instrument

import androidx.compose.ui.graphics.Color

data class RackInfo(val rackId: Int, val rackName: String, var state: RackState)

enum class RackState(val desc: String, val color: Color) {
    SELECT("选中", Color.Red),
    WAITING("等待", Color.Blue),
    TESTING("检测中", Color.Gray),
    NOT_USED("待用", Color.White),
}

val RackList = List(14) { RackInfo(it, "AA${if (it + 1 < 10) "0" + (it + 1) else it + 1}", RackState.NOT_USED) }

