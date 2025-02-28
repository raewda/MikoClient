package com.example.miko.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.miko.ui.theme.four
import com.example.miko.ui.theme.one
import com.example.miko.ui.theme.two
import com.example.miko.ui.theme.zk

@Composable
fun Buy(
    navController: NavHostController,
    buy: MutableState<Boolean>,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = one
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                TextButton(
                    modifier = Modifier,
                    onClick = {
                    navController.navigateUp()
                }) {
                    Text(
                        text = "назад",
                        modifier = Modifier.padding(vertical = 10.dp),
                        fontFamily = zk,
                        fontSize = 20.sp,
                        color = four
                    )
                }

                IconButton(
                    modifier = Modifier
                        .size(30.dp),
                    onClick = {

                    },
                    colors = IconButtonDefaults.iconButtonColors(
                        containerColor = four,
                        contentColor = two
                    )
                ) {
                    Icon(
                        Icons.Filled.Info,
                        contentDescription = "info dialog"
                    )
                }
            }

        }
    }
}