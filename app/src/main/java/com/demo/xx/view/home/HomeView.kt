package com.demo.xx.view.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.demo.xx.viewmodel.HomeViewModel


@Composable
fun HomeView(homeViewModel: HomeViewModel) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.White)
        ) {
            HomeLeftView(viewModel = homeViewModel)
        }

        Spacer(modifier = Modifier.width(10.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.White)
        ) {
            HomeMidView(viewModel = homeViewModel)
        }

        Spacer(modifier = Modifier.width(10.dp))

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .background(Color.White)
        ) {
            HomeRightView(viewModel = homeViewModel)
        }
    }
}
