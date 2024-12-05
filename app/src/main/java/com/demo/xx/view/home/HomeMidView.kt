package com.demo.xx.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.xx.R
import com.demo.xx.viewmodel.HomeViewModel

@Composable
fun HomeMidView(viewModel: HomeViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(1.dp, Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(R.mipmap.ic_home_view_barrel),
                contentDescription = null,
                modifier = Modifier.size(22.dp)
            )

            Text(
                text = "试剂仓",
                fontSize = 22.sp,
                modifier = Modifier.padding(start = 10.dp, bottom = 3.dp)
            )
        }

        Box(
            modifier = Modifier.padding(start = 20.dp, end = 20.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
            )
        }

    }

}