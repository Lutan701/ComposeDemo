package com.demo.xx.view.test

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.xx.viewmodel.TestViewModel
import com.demo.xx.R

@Composable
fun TestView(testViewModel: TestViewModel) {
    val navController = rememberNavController()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
                .background(Color.White)
        ) {
            TopTabBar(text = "Apply", R.mipmap.ic_home_view_barrel, onClick = { navController.navigate("Apply") })
            TopTabBar(text = "Test", R.mipmap.ic_home_view_barrel, onClick = { navController.navigate("Test") })
            TopTabBar(text = "Record", R.mipmap.ic_home_view_barrel, onClick = { navController.navigate("Record") })
            TopTabBar(text = "Report", R.mipmap.ic_home_view_barrel, onClick = { navController.navigate("Report") })
        }

        NavHost(
            navController = navController,
            startDestination = "Apply"
        ) {
            composable("Apply") { TestApplyView(viewModel = testViewModel) }
            composable("Test") { Text("Test") }
            composable("Record") { TestRecordView(testViewModel = testViewModel) }
            composable("Report") { TestReportView() }
        }
    }
}

@Composable
fun TopTabBar(text: String, @DrawableRes icon: Int, onClick: () -> Unit = {}) {
    Row(
        modifier = Modifier.clickable { onClick() },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(22.dp),
            painter = painterResource(icon),
            contentDescription = null
        )
        Text(text = text, modifier = Modifier.padding(10.dp))
    }
}