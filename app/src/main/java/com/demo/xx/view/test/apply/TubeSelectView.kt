package com.demo.xx.view.test.apply

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TubeSelectView(modifier: Modifier) {

    val tubes = List(8) { it }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .border(1.dp, color = Color.Black),
    ) {
        Header()

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(tubes, key = { it }) { tube ->
                TubeItem(tubeIndex = tube + 1)
            }
        }

        Footer()
    }
}


@Composable
private fun Header() {
    Row {
        Text(
            text = "位号", fontSize = 18.sp, modifier = Modifier
                .weight(0.5f)
                .padding(vertical = 10.dp), textAlign = TextAlign.Center
        )
        Text(
            text = "编号", fontSize = 18.sp, modifier = Modifier
                .weight(1.2f)
                .padding(horizontal = 5.dp, vertical = 10.dp), textAlign = TextAlign.Center
        )
        Text(
            text = "条码", fontSize = 18.sp, modifier = Modifier
                .weight(2.5f)
                .padding(horizontal = 5.dp, vertical = 10.dp), textAlign = TextAlign.Center
        )
        Text(
            text = "样本类型", fontSize = 18.sp, modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp, vertical = 10.dp), textAlign = TextAlign.Center
        )
        Text(
            text = "样本管类型", fontSize = 18.sp, modifier = Modifier
                .weight(1.2f)
                .padding(horizontal = 5.dp, vertical = 10.dp), textAlign = TextAlign.Center
        )
        Text(
            text = "预稀释", fontSize = 18.sp, modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp, vertical = 10.dp), textAlign = TextAlign.Center
        )
        Text(
            text = "备注", fontSize = 18.sp, modifier = Modifier
                .weight(1.8f)
                .padding(horizontal = 5.dp, vertical = 10.dp), textAlign = TextAlign.Center
        )
        Text(text = "  ", fontSize = 18.sp, modifier = Modifier.width(60.dp), textAlign = TextAlign.Center)
    }

    HorizontalDivider()
}

@Composable
private fun TubeItem(tubeIndex: Int) {

    val context = LocalContext.current
    val sampleTypes = listOf("血清", "血浆", "全血", "尿液")
    var sampleTypeSelection by remember { mutableStateOf(sampleTypes[0]) }
    var sampleNo by rememberSaveable { mutableStateOf("") }
    var lisNo by rememberSaveable { mutableStateOf("") }
    var preDiluent by rememberSaveable { mutableIntStateOf(1) }
    var note by rememberSaveable { mutableStateOf("") }

    val refreshCount = remember { mutableIntStateOf(0) }
    LaunchedEffect(key1 = Unit) {
        refreshCount.intValue += 1
        Log.e("TubeItem", "TubeItem $tubeIndex refreshCount: ${refreshCount.intValue}")
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(text = tubeIndex.toString(), fontSize = 24.sp, modifier = Modifier.weight(0.5f), textAlign = TextAlign.Center)

        OutlinedTextField(
            value = sampleNo,
            onValueChange = { sampleNo = it },
            modifier = Modifier
                .weight(1.2f)
                .padding(horizontal = 5.dp),
            singleLine = true,
            textStyle = TextStyle(fontSize = 18.sp, lineHeight = 24.sp, textAlign = TextAlign.Center)
        )

        OutlinedTextField(
            value = lisNo,
            onValueChange = { lisNo = it },
            modifier = Modifier
                .weight(2.5f)
                .padding(horizontal = 5.dp),
            singleLine = true,
            textStyle = TextStyle(fontSize = 18.sp, lineHeight = 24.sp, textAlign = TextAlign.Center)
        )

        DropDownMenu(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp),
            options = sampleTypes,
            onItemSelected = { sampleTypeSelection = it }
        )

        DropDownMenu(
            modifier = Modifier
                .weight(1.2f)
                .padding(horizontal = 5.dp),
            options = sampleTypes,
            onItemSelected = { sampleTypeSelection = it }
        )

        OutlinedTextField(
            value = preDiluent.toString(),
            onValueChange = { preDiluent = it.toInt() },
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 5.dp),
            singleLine = true,
            textStyle = TextStyle(fontSize = 18.sp, lineHeight = 24.sp, textAlign = TextAlign.Center)
        )

        OutlinedTextField(
            value = note,
            onValueChange = { note = it },
            modifier = Modifier
                .weight(1.8f)
                .padding(horizontal = 5.dp),
            singleLine = true,
            textStyle = TextStyle(fontSize = 18.sp, lineHeight = 24.sp, textAlign = TextAlign.Center)
        )

        IconTubeDelete(
            modifier = Modifier.width(60.dp),
            size = 32.dp,
            onClick = {
                Toast.makeText(context, "delete1", Toast.LENGTH_SHORT).show()
            }
        )
    }
}

@Preview
@Composable
private fun Footer() {
    HorizontalDivider()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "AA",
            fontSize = 48.sp,
            style = TextStyle(fontWeight = FontWeight.Black),
        )

        Spacer(modifier = Modifier.weight(1f))

        Checkbox(
            checked = true,
            onCheckedChange = { }
        )
        Text(
            text = "自动编号",
        )

        Checkbox(
            checked = false,
            onCheckedChange = { }
        )
        Text(
            text = "批量申请",
        )
    }
}