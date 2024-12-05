package com.demo.xx.view.test.apply

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.xx.instrument.RackState
import com.demo.xx.viewmodel.TestViewModel

@Composable
fun RackSelectView(viewModel: TestViewModel) {

    val context = LocalContext.current
    val racks by viewModel.racks.observeAsState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(Color.White)
            .border(width = 1.dp, color = Color.Black, shape = RectangleShape),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier.padding(start = 40.dp, end = 40.dp)
        ) {
            RackState.entries.forEach {
                Row(
                    modifier = Modifier.padding(5.dp), verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(18.dp)
                            .clip(CircleShape)
                            .background(it.color)
                            .border(width = 1.dp, color = if (it.color == Color.White) Color.Black else it.color, shape = CircleShape)
                    )
                    Text(text = it.desc, modifier = Modifier.padding(start = 10.dp))
                }
            }
        }

        VerticalDivider(thickness = 0.5.dp, color = Color.Black)

        Column(modifier = Modifier.weight(1f)) {
            racks!!.chunked(racks!!.size / 2).forEach {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    it.forEach { rack ->
                        RackButton(
                            rack = rack,
                            onClick = { rackInfo ->
                                Toast.makeText(context, rack.rackName, Toast.LENGTH_SHORT).show()
                                viewModel.changeRackState(rackInfo.rackId, RackState.SELECT)
                            }
                        )
                    }
                }
            }
        }

        VerticalDivider(thickness = 0.5.dp, color = Color.Black)

        Column(
            modifier = Modifier.padding(start = 40.dp, end = 40.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BlueButton(
                text = "清除",
                fontSize = 18.sp,
                onClick = {
                    racks!!.forEachIndexed { index, _ ->
                        viewModel.changeRackState(index, RackState.NOT_USED)
                    }
                }
            )
            BlueButton(text = "急诊", fontSize = 18.sp)
        }

    }
}
