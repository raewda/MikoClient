package com.example.miko

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.miko.dcl.Orders
import com.example.miko.screens.ApplicationInfo
import com.example.miko.screens.Autorization
import com.example.miko.screens.Brand
import com.example.miko.screens.Buy
import com.example.miko.screens.Katalog
import com.example.miko.screens.Offer
import com.example.miko.screens.Order
import com.example.miko.screens.Profile
import com.example.miko.screens.Registration
import com.example.miko.screens.Start
import com.example.miko.ui.theme.MikoTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
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
                val profile = remember { mutableStateOf(false) }
                val brand = remember { mutableStateOf(false) }
                val order = remember { mutableStateOf(false) }
                val katalog = remember { mutableStateOf(false) }
                val offer = remember { mutableStateOf(false) }
                val buy = remember { mutableStateOf(false) }

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
                    composable("profile") {
                        Profile(
                            navController,
                            profile = profile
                        )
                    }
                    composable("brand") {
                        Brand(
                            navController,
                            brand = brand
                        )
                    }
                    composable("order") {
                        Order(
                            navController,
                            order = order
                        )
                    }
                    composable("katalog") {
                        Katalog(
                            navController,
                            katalog = katalog
                        )
                    }
                    composable("offer/{id}", arguments = listOf(navArgument("id"){
                        NavType.StringType
                    })) {
                        val id = it.arguments?.getString("id")?.toInt()
                        Offer(
                            navController,
                            offer = offer,
                            item = Orders.getById(id?:0)
                        )
                    }
                    composable("buy/{id}", arguments = listOf(navArgument("id"){
                        NavType.StringType
                    })) {
                        val id = it.arguments?.getString("id")?.toInt()
                        Buy(
                            navController,
                            buy = buy,
                            item = Orders.getById(id?:0)
                        )
                    }
                }
            }
        }
    }
}
