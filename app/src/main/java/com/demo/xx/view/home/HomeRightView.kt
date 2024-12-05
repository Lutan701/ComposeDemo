package com.demo.xx.view.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.xx.R
import com.demo.xx.instrument.Diluent
import com.demo.xx.instrument.PlaceHolder
import com.demo.xx.instrument.WellPlate
import com.demo.xx.view.home.widget.CircleProgressBar
import com.demo.xx.viewmodel.HomeViewModel

@Composable
fun HomeRightView(viewModel: HomeViewModel) {

    val context = LocalContext.current

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
                text = "耗材",
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

        val firstColumn = listOf(Diluent.DILUENT4, Diluent.DILUENT5, Diluent.DILUENT6, WellPlate.WELL_PLATE_P96)
        val secondColumn = listOf(Diluent.DILUENT1, Diluent.DILUENT2, Diluent.DILUENT3, PlaceHolder.PLACE_HOLDER)

        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceEvenly,
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                firstColumn.forEach { consumable ->
                    CircleProgressBar(
                        text = consumable.desc,
                        fontSize = 16f,
                        progress = 50f,
                        radius = 60f,
                        bgStrokeWidth = 20f,
                        fgStrokeWidth = 8f,
                        onClick = {
                            Toast.makeText(context, "Clicked on ${consumable.desc}", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }

            Column(
                modifier = Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                secondColumn.forEach { consumable ->
                    if (consumable == PlaceHolder.PLACE_HOLDER) {
                        Box(modifier = Modifier.alpha(0f)) {
                            CircleProgressBar(
                                text = consumable.desc,
                                fontSize = 16f,
                                progress = 50f,
                                radius = 60f,
                                bgStrokeWidth = 20f,
                                fgStrokeWidth = 8f
                            )
                        }
                    } else {
                        CircleProgressBar(
                            text = consumable.desc,
                            fontSize = 16f,
                            progress = 50f,
                            radius = 60f,
                            bgStrokeWidth = 20f,
                            fgStrokeWidth = 8f,
                            onClick = {
                                Toast.makeText(context, "Clicked on ${consumable.desc}", Toast.LENGTH_SHORT).show()
                            }
                        )
                    }
                }
            }
        }
    }

}