package com.demo.xx.view.home.widget

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

/**
 *
 * @param text String    文本
 * @param fontSize Float 字体大小
 * @param progress Int  进度0-100
 * @param radius Int    半径
 * @param bgStrokeWidth Int 背景线宽
 * @param fgStrokeWidth Int 前景线宽
 */
@Composable
fun CircleProgressBar(text: String, fontSize: Float, progress: Float, radius: Float, bgStrokeWidth: Float, fgStrokeWidth: Float, onClick: () -> Unit = {}) {
    Canvas(
        modifier = Modifier
            .size(radius.dp * 2)
            .background(Color.White)
            .clickable { onClick() }
    ) {

        // 绘制背景
        drawCircle(
            color = Color.LightGray,
            radius = radius - bgStrokeWidth / 2,
            center = center,
            style = Stroke(width = bgStrokeWidth)
        )

        // 绘制背景虚线
        val path = Path()
        val step = 10

        for (angle in 0 until 360 step step) {
            val x1 = center.x + (radius - bgStrokeWidth / 2) * cos(Math.toRadians(angle.toDouble())).toFloat()
            val y1 = center.y + (radius - bgStrokeWidth / 2) * sin(Math.toRadians(angle.toDouble())).toFloat()
            val x2 = center.x + (radius - bgStrokeWidth / 2) * cos(Math.toRadians((angle + step).toDouble())).toFloat()
            val y2 = center.y + (radius - bgStrokeWidth / 2) * sin(Math.toRadians((angle + step).toDouble())).toFloat()
            if (angle == 0) {
                path.moveTo(x1, y1)
            }
            path.lineTo(x2, y2)
        }

        val pathEffect = PathEffect.dashPathEffect(floatArrayOf(4F, 4F)) // 线段长度, 间隔长度

        drawPath(
            path = path,
            color = Color.Gray,
            style = Stroke(width = 2F, pathEffect = pathEffect)
        )

        // 绘制进度条
        rotate(-90f) {  // 0度在右边，-90度在上边，所以要旋转-90度
            drawArc(
                brush = Brush.sweepGradient(
                    colors = listOf(Color(0xFF7ADFC1), Color(0xFF6DBCCD), Color(0xFF4D61EF)),
                ),
                startAngle = 0f,
                sweepAngle = 360f / 100f * progress,
                useCenter = false,
                topLeft = Offset(bgStrokeWidth / 2, bgStrokeWidth / 2),
                size = Size(radius * 2 - bgStrokeWidth, radius * 2 - bgStrokeWidth),
                style = Stroke(width = fgStrokeWidth, cap = StrokeCap.Round)
            )
        }

        // 绘制文本
        drawIntoCanvas { canvas ->
            val paint = Paint().apply {
                color = android.graphics.Color.BLACK
                textSize = fontSize
                textAlign = android.graphics.Paint.Align.CENTER
            }

            // 获取字体度量信息
            val fontMetrics = paint.fontMetrics
            val textHeight = fontMetrics.bottom - fontMetrics.top
            val offsetY = (textHeight / 2) - fontMetrics.bottom // 基线到文本中心的偏移量

            canvas.nativeCanvas.drawText(
                text,
                center.x,
                center.y + offsetY,
                paint
            )
        }

        // 绘制起始点圆圈的外圈
        drawCircle(
            color = Color.Red,
            radius = bgStrokeWidth / 2 - 4f,
            center = Offset(radius, bgStrokeWidth / 2f),
            style = Stroke(width = 4f)
        )

        // 绘制起始点圆圈的内圈
        drawCircle(
            color = Color.White,
            radius = 3f,
            center = Offset(radius, bgStrokeWidth / 2f)
        )

    }

}
