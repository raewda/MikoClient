package com.example.miko.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.miko.R
import com.example.miko.ui.theme.four
import com.example.miko.ui.theme.one
import com.example.miko.ui.theme.three
import com.example.miko.ui.theme.two
import com.example.miko.ui.theme.zk

@Composable
fun Start(
    navController: NavHostController,
    start: MutableState<Boolean>
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(), containerColor = one
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.fox),
                contentDescription = "fox",
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
            )

            Text(
                text = "RAEWDA PRODUCTION",
                modifier = Modifier,
                fontSize = 28.sp,
                color = four,
                fontFamily = zk
            )

            Column(
                modifier = Modifier
                    .padding(vertical = 60.dp)
                    .padding(horizontal = 25.dp)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Button(
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 30.dp, 0.dp
                        ),
                        modifier = Modifier
                            .size(250.dp, 50.dp),
                        onClick = {
                            navController.navigate("autorization")
                        },
                        border = BorderStroke(
                            width = 2.dp,
                            color = four),
                        colors = ButtonDefaults.buttonColors(two)
                    ) {
                        Text(
                            text = "АВТОРИЗАЦИЯ",
                            modifier = Modifier,
                            fontFamily = zk,
                            color = four,
                            fontSize = 24.sp
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Button(
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 0.dp, 30.dp
                        ),
                        modifier = Modifier
                            .size(250.dp, 50.dp),
                        onClick = {

                        },
                        border = BorderStroke(
                            width = 2.dp,
                            color = four),
                        colors = ButtonDefaults.buttonColors(two)
                    ) {
                        Text(
                            text = "РЕГИСТРАЦИЯ",
                            modifier = Modifier,
                            fontFamily = zk,
                            color = four,
                            fontSize = 24.sp
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 20.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Button(
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 30.dp, 0.dp
                        ),
                        modifier = Modifier
                            .size(250.dp, 50.dp),
                        onClick = {

                        },
                        border = BorderStroke(
                            width = 2.dp,
                            color = four),
                        colors = ButtonDefaults.buttonColors(two)
                    ) {
                        Text(
                            text = "О ПРИЛОЖЕНИИ",
                            modifier = Modifier,
                            fontFamily = zk,
                            color = four,
                            fontSize = 24.sp
                        )
                    }
                }
            }

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = three)) {
                        append("М")
                    }
                    withStyle(style = SpanStyle(color = four)) {
                        append("и")
                    }
                    withStyle(style = SpanStyle(color = two)) {
                        append("к")
                    }
                    withStyle(style = SpanStyle(color = three)) {
                        append("о")
                    }
                },
                modifier = Modifier,
                fontFamily = zk,
                fontSize = 65.sp
            )
        }
    }
}