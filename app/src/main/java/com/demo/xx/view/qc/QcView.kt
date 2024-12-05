package com.demo.xx.view.qc

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import com.demo.xx.viewmodel.QcViewModel

@Composable
fun QcView(qcViewModel: QcViewModel) {

    val refreshCount = remember { mutableIntStateOf(0) }
    LaunchedEffect(Unit) {
        refreshCount.intValue += 1
        Log.e("QcView", "QcView refreshCount: ${refreshCount.intValue}")
    }


    Text(text = "QC View", modifier = Modifier.onGloballyPositioned {
        Log.e("QcView", "onGloballyPositioned refreshCount: ${refreshCount.intValue}")
    })

}