package com.demo.xx.view.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun AppStateView() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(Color.White)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = "DEMO", fontSize = 24.sp, style = TextStyle(fontWeight = FontWeight.Bold))

        Spacer(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        )

        TextClock()
    }
}

@Composable
private fun TextClock() {
    var currentTime by remember { mutableStateOf(LocalDateTime.now()) }
    val formattedTime = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = LocalDateTime.now()
            kotlinx.coroutines.delay(1000)
        }
    }
    Text(text = formattedTime)
}