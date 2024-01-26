package com.example.appforcv_jc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.appforcv_jc.detail.DetailScreen
import com.example.appforcv_jc.home.Home
import com.example.appforcv_jc.ui.theme.JetPetTheme

enum class Screen{
    HOME_PAGE,
    DETAIL_PAGE
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkTheme by remember {
                mutableStateOf(false)
            }
            var currentScreen by remember{
                mutableStateOf(Screen.HOME_PAGE)
            }
            var selectedIndex by remember{
                mutableStateOf(-1)
            }
            JetPetTheme(
                darkTheme = isDarkTheme
            ) {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    when (currentScreen) {
                        Screen.HOME_PAGE -> {
                            Home(
                                onSwitchClick = {isDarkTheme = !isDarkTheme},
                                onPetClick = { index ->
                                    currentScreen = Screen.DETAIL_PAGE
                                    selectedIndex = index
                                }
                            )
                        }
                        Screen.DETAIL_PAGE -> {
                            DetailScreen(index = selectedIndex) {
                                currentScreen = Screen.HOME_PAGE
                            }
                        }
                    }
                }
            }
        }
    }
}
