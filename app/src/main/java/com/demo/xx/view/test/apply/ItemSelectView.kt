package com.demo.xx.view.test.apply

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun ItemSelectView(modifier: Modifier) {

    val items = List(8) { it }

    Column(
        modifier = modifier
            .fillMaxSize()
            .border(1.dp, color = Color.Black)
            .background(Color.White)
    ) {

        Header()

        LazyColumn {
            items(items, key = { it }) {
                BodyItem()
            }
        }
    }

}

@Composable
private fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "", modifier = Modifier.width(60.dp), textAlign = TextAlign.Center)
        Text(text = "项目", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
        Text(text = "稀释倍数", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
        Text(text = "检测次数", modifier = Modifier.weight(1f), textAlign = TextAlign.Center)
        Text(text = "", modifier = Modifier.width(60.dp), textAlign = TextAlign.Center)
    }
}

@Composable
private fun BodyItem() {

    val context = LocalContext.current
    var dilution by remember { mutableIntStateOf(1) }
    var testCount by remember { mutableIntStateOf(1) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = false,
            onCheckedChange = { },
            modifier = Modifier.width(60.dp)
        )

        Text(
            text = "PGI",
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value = dilution.toString(),
            onValueChange = { dilution = it.toInt() },
            modifier = Modifier.weight(1f),
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )

        OutlinedTextField(
            value = testCount.toString(),
            onValueChange = { testCount = it.toInt() },
            modifier = Modifier.weight(1f),
            textStyle = TextStyle(textAlign = TextAlign.Center)
        )

        IconTubeAdd(
            modifier = Modifier.width(60.dp),
            size = 32.dp,
            onClick = {
                Toast.makeText(context, "Add", Toast.LENGTH_SHORT).show()
            })
    }

}