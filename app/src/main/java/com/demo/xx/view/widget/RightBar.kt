package com.demo.xx.view.widget

import android.widget.Toast
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.xx.R
import com.demo.xx.view.theme.ThemeBlue

@Preview
@Composable
fun RightBar() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .width(140.dp)
            .background(ThemeBlue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        RightBarButton(imageRes = R.mipmap.ic_main_tab_home, text = "账户", onClick = { Toast.makeText(context, "账户", Toast.LENGTH_SHORT).show() })
        RightBarButton(imageRes = R.mipmap.ic_main_tab_home, text = "警告", onClick = { Toast.makeText(context, "警告", Toast.LENGTH_SHORT).show() })

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        RightBarButton(imageRes = R.mipmap.ic_main_tab_home, text = "急停", onClick = { Toast.makeText(context, "急停", Toast.LENGTH_SHORT).show() })
        RightBarButton(imageRes = R.mipmap.ic_main_tab_home, text = "全归零", onClick = { Toast.makeText(context, "全归零", Toast.LENGTH_SHORT).show() })
        RightBarButton(imageRes = R.mipmap.ic_main_tab_home, text = "暂停取样", onClick = { Toast.makeText(context, "暂停取样", Toast.LENGTH_SHORT).show() })
        RightBarButton(imageRes = R.mipmap.ic_main_tab_home, text = "开始", onClick = { Toast.makeText(context, "开始", Toast.LENGTH_SHORT).show() })
    }

}

@Composable
fun RightBarButton(@DrawableRes imageRes: Int, text: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(top = 10.dp, bottom = 10.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageRes),
            modifier = Modifier.size(60.dp),
            contentDescription = "home image",
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = text,
            fontSize = 20.sp,
            color = Color.White
        )
    }

}