package com.demo.xx.view.test.apply

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun IconTubeDelete(modifier: Modifier, size: Dp = 24.dp, enable: Boolean = true, onClick: () -> Unit = {}) {

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = modifier
                .size(size)
                .clickable { if (enable) onClick() }
        ) {

            Canvas(
                modifier = Modifier.fillMaxSize()
            ) {
                drawCircle(color = if (enable) Color.Red else Color.Gray, radius = size.value / 2f)

                rotate(-45f, center) {
                    drawLine(
                        color = Color.White,
                        start = Offset(center.x - size.value / 4f, center.y - size.value / 4f),
                        end = Offset(center.x + size.value / 4f, center.y + size.value / 4f),
                        strokeWidth = 4f
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun IconTubeDeletePreview() {
    IconTubeDelete(modifier = Modifier.size(24.dp))
}