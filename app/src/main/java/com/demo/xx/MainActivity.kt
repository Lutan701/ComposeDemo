package com.demo.xx

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.demo.xx.view.home.HomeView
import com.demo.xx.view.maintenance.MaintenanceView
import com.demo.xx.view.qc.QcView
import com.demo.xx.view.setting.SettingView
import com.demo.xx.view.test.TestView
import com.demo.xx.view.theme.BOHXXTheme
import com.demo.xx.view.widget.AppStateView
import com.demo.xx.view.widget.LeftBar
import com.demo.xx.view.widget.RightBar
import com.demo.xx.viewmodel.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeViewModel: HomeViewModel by viewModels()
    private val testViewModel: TestViewModel by viewModels()
    private val qcViewModel: QcViewModel by viewModels()
    private val settingViewModel: SettingViewModel by viewModels()
    private val mtViewModel: MtViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                )

        setContent {
            BOHXXTheme {
                MainView(homeViewModel, testViewModel, qcViewModel, settingViewModel, mtViewModel)
            }
        }
    }

}

@Composable
fun MainView(
    homeViewModel: HomeViewModel,
    testViewModel: TestViewModel,
    qcViewModel: QcViewModel,
    settingViewModel: SettingViewModel,
    mtViewModel: MtViewModel,
) {
    val navController = rememberNavController()

    val tabOptions = listOf(
        TabOption(0, stringResource(id = R.string.main_tab_home), R.mipmap.ic_main_tab_home),
        TabOption(1, stringResource(id = R.string.main_tab_test), R.mipmap.ic_main_tab_home),
        TabOption(2, stringResource(id = R.string.main_tab_qc), R.mipmap.ic_main_tab_home),
        TabOption(3, stringResource(id = R.string.main_tab_setting), R.mipmap.ic_main_tab_home),
        TabOption(4, stringResource(id = R.string.main_tab_maintenance), R.mipmap.ic_main_tab_home),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEDEDED))
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            LeftBar(
                navController = navController,
                tabOptions = tabOptions,
                defaultTab = tabOptions[0].tabName
            )

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                ) {
                    AppStateView()

                    NavHost(
                        navController = navController,
                        startDestination = tabOptions[0].tabName
                    ) {
                        composable(tabOptions[0].tabName) {
                            HomeView(homeViewModel)
                        }
                        composable(tabOptions[1].tabName) {
                            TestView(testViewModel)
                        }
                        composable(tabOptions[2].tabName) {
                            QcView(qcViewModel)
                        }
                        composable(tabOptions[3].tabName) {
                            SettingView(settingViewModel)
                        }
                        composable(tabOptions[4].tabName) {
                            MaintenanceView(mtViewModel)
                        }
                    }
                }
            }

            RightBar()
        }
    }
}


data class TabOption(
    var tabIndex: Int = 0,
    var tabName: String = "",
    @DrawableRes var tabImageRes: Int = 0,
)