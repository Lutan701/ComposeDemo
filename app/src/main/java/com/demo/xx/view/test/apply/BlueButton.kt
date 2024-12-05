package com.demo.xx.view.test.apply

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.xx.view.theme.ThemeBlue

@Composable
fun BlueButton(text: String, fontSize: TextUnit, onClick: () -> Unit = {}) {
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed = interactionSource.collectIsPressedAsState()

    Button(
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        onClick = {
            Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
            onClick()
        },
        contentPadding = PaddingValues(start = 20.dp, top = 2.dp, end = 20.dp, bottom = 2.dp),
        shape = RectangleShape,
        modifier = Modifier
            .background(if (isPressed.value) Color.LightGray else ThemeBlue)
            .size(100.dp, 40.dp)
    ) {
        Text(text = text, fontSize = fontSize)
    }
}

@Preview
@Composable
fun BlueButtonPreview() {
    BlueButton(text = "确定", fontSize = 16.sp)
}