package com.demo.xx.view.test

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned

@Composable
fun TestReportView() {

    val refreshCount = remember { mutableIntStateOf(0) }

    Text(text = "TextReportView", modifier = Modifier.onGloballyPositioned {
        refreshCount.intValue += 1
        Log.e("TestReportView", "TestReportView refreshCount: ${refreshCount.intValue}")
    })
}