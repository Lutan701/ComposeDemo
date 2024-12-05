package com.demo.xx.view.test.apply

import android.util.Log
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.xx.instrument.RackInfo

@Composable
fun RackButton(rack: RackInfo, onClick: (RackInfo) -> Unit = {}) {

    val context = LocalContext.current

    val refreshCount = remember { mutableIntStateOf(0) }

    OutlinedButton(
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = rack.state.color,
            contentColor = Color.Black
        ),
        modifier = Modifier.width(108.dp).onGloballyPositioned {
            refreshCount.intValue += 1
            Log.e("RackButton", "RackButton ${rack.rackName} refreshCount = ${refreshCount.intValue}")
        },
        onClick = {
            onClick(rack)
        }
    ) {
        Text(text = rack.rackName, fontSize = 20.sp)
    }

}