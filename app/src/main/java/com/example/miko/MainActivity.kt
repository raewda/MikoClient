package com.example.miko

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.miko.screens.ApplicationInfo
import com.example.miko.screens.Autorization
import com.example.miko.screens.Registration
import com.example.miko.screens.Start
import com.example.miko.ui.theme.MikoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MikoTheme {
                val navController = rememberNavController()
                val start = remember { mutableStateOf(false) }
                val autorization = remember { mutableStateOf(false) }
                val registration = remember { mutableStateOf(false) }
                val applicationinfo = remember { mutableStateOf(false) }

                NavHost(
                    navController = navController,
                    startDestination = "start"
                ) {
                    composable("start") {
                        Start(
                            navController,
                            start = start
                        )
                    }
                    composable("autorization") {
                        Autorization(
                            navController,
                            autorization = autorization
                        )
                    }
                    composable("registration") {
                        Registration(
                            navController,
                            registration = registration
                        )
                    }
                    composable("applicationinfo") {
                        ApplicationInfo(
                            navController,
                            applicationinfo = applicationinfo
                        )
                    }
                }
            }
        }
    }
}
