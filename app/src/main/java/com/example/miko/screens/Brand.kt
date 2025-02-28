package com.example.miko.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.miko.R
import com.example.miko.ui.theme.four
import com.example.miko.ui.theme.one
import com.example.miko.ui.theme.zk

@Composable
fun Brand(
    navController : NavHostController,
    brand : MutableState<Boolean>
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = one
    ){ innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.Start
            ) {
                TextButton(
                    modifier = Modifier,
                    onClick = {
                        navController.navigateUp()
                    }
                ) {
                    Text(
                        text = "назад",
                        modifier = Modifier
                            .padding(vertical = 10.dp),
                        fontFamily = zk,
                        fontSize = 20.sp,
                        color = four
                    )
                }
            }

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "БРЕНД",
                    modifier = Modifier
                        .padding(vertical = 10.dp),
                    fontFamily = zk,
                    fontSize = 40.sp,
                    color = four
                )

                Text(
                    text = stringResource(R.string.login),
                    fontFamily = zk,
                    fontSize = 30.sp,
                    color = four,
                    textAlign = TextAlign.Center
                )

                Text(
                    text = stringResource(R.string.email),
                    fontFamily = zk,
                    fontSize = 25.sp,
                    color = four
                )
            }

            Text(
                text = stringResource(R.string.application_info),
                modifier = Modifier
                    .padding(vertical = 10.dp),
                fontFamily = zk,
                fontSize = 30.sp,
                color = four
            )
        }
    }
}