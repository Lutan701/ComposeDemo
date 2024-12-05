package com.demo.xx.view.widget

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.demo.xx.TabOption
import com.demo.xx.view.theme.ThemeBlue

@Composable
fun LeftBar(navController: NavController, tabOptions: List<TabOption>, defaultTab: String) {

    var selectedTab by remember { mutableStateOf(defaultTab) }

    Column(
        Modifier
            .fillMaxHeight()
            .background(ThemeBlue)
    ) {
        tabOptions.forEach { tab ->
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .width(140.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LeftBarRadioButton(
                    selected = tab.tabName == selectedTab,
                    onSelect = {
                        navController.navigate(tab.tabName)
                        selectedTab = tab.tabName
                    },
                    text = tab.tabName,
                    imageRes = tab.tabImageRes
                )
            }
        }
    }
}

@Composable
private fun LeftBarRadioButton(selected: Boolean, onSelect: () -> Unit, text: String, @DrawableRes imageRes: Int) {
    Column(
        modifier = Modifier
            .clickable(onClick = onSelect)
            .background(if (selected) Color.Red else Color.Transparent),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageRes),
            modifier = Modifier.size(60.dp),
            contentDescription = "home image",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.White
        )
    }
}