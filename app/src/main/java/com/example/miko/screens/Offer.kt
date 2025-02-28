package com.example.miko.screens

import android.graphics.Paint.Align
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.miko.dcl.Orders
import com.example.miko.ui.theme.four
import com.example.miko.ui.theme.one
import com.example.miko.ui.theme.three
import com.example.miko.ui.theme.zk

@Composable
fun Offer(
    navController : NavHostController,
    offer : MutableState<Boolean>,
    item : Orders
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

            offerItem(item)

            Button(
                modifier = Modifier,
                onClick = {
                    navController.navigate("buy")
                },
                border = BorderStroke(
                    width = 2.dp,
                    color = four),
                colors = ButtonDefaults.buttonColors(three),
                shape = RoundedCornerShape(
                    30.dp, 30.dp, 30.dp, 30.dp
                )
            ) {
                Text(
                    text = "ЗАКАЗАТЬ",
                    modifier = Modifier,
                    fontFamily = zk,
                    color = four,
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Composable
fun offerItem (
    item : Orders
){
    Text(
        text = item.orderName,
        fontSize = 44.sp,
        fontFamily = zk,
        color = four,
        modifier = Modifier
            .padding(horizontal = 15.dp),
        lineHeight = 50.sp,
        textAlign = TextAlign.Center
    )
    Text(
        text = item.orderCode.toString(),
        fontSize = 24.sp,
        fontFamily = zk,
        color = four,
        modifier = Modifier
            .padding(horizontal = 10.dp),
        lineHeight = 50.sp
    )

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(item.orderImage),
            contentDescription = "image",
            modifier = Modifier
                .size(300.dp)
        )
    }

    Text(
        text = item.orderCharacter,
        modifier = Modifier
            .padding(horizontal = 10.dp),
        fontSize = 24.sp,
        fontFamily = zk,
        color = four
    )
}