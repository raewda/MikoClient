package com.example.miko.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
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
fun Profile(
    navController: NavHostController,
    profile : MutableState<Boolean>
){
    val userName = remember { mutableStateOf("") }
    val userAdress = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = one,
        bottomBar = {
            BottomAppBar(
                actions = {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {

                        Button(
                            modifier = Modifier,
                            onClick = {
                                //
                            },
                            border = BorderStroke(
                                width = 2.dp,
                                color = four
                            ),
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                            shape = RoundedCornerShape(
                                30.dp, 30.dp, 30.dp, 0.dp
                            )
                        ) {
                            Image(
                                painter = painterResource(R.drawable.navkatalog),
                                contentDescription = "nav katalog",
                                modifier = Modifier
                            )
                        }

                        Button(
                            modifier = Modifier,
                            onClick = {
                                navController.navigate("profile")
                            },
                            border = BorderStroke(
                                width = 2.dp,
                                color = four
                            ),
                            colors = ButtonDefaults.buttonColors(two),
                            shape = RoundedCornerShape(
                                30.dp, 30.dp, 0.dp, 30.dp
                            )
                        ) {
                            Image(painter = painterResource(R.drawable.navprofile),
                                contentDescription = "nav profile",
                                modifier = Modifier
                            )
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth(),
                containerColor = Color.Transparent
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ПРОФИЛЬ",
                    fontFamily = zk,
                    fontSize = 40.sp,
                    color = four
                )

                Text(
                    text = stringResource(R.string.login),
                    fontFamily = zk,
                    fontSize = 30.sp,
                    color = four
                )

                Text(
                    text = stringResource(R.string.email),
                    fontFamily = zk,
                    fontSize = 25.sp,
                    color = four
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    OutlinedTextField(
                        value = userName.value, onValueChange = { new ->
                            userName.value = new.uppercase()
                        },
                        modifier = Modifier,
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 30.dp, 0.dp
                        ),
                        enabled = true,
                        readOnly = false,
                        textStyle = TextStyle(
                            fontFamily = zk,
                            fontSize = 18.sp,
                            color = four
                        ), placeholder = {
                            Text(
                                "ИМЯ",
                                color = three,
                                fontFamily = zk,
                                fontSize = 24.sp,
                            )
                        }, colors = TextFieldDefaults.colors(
                            cursorColor = three,
                            focusedContainerColor = two,
                            unfocusedContainerColor = two,
                            focusedIndicatorColor = four,
                            unfocusedIndicatorColor = four
                        )
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    OutlinedTextField(
                        value = userAdress.value, onValueChange = { new ->
                            userAdress.value = new.uppercase()
                        },
                        modifier = Modifier,
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 30.dp, 0.dp
                        ),
                        enabled = true,
                        readOnly = false,
                        textStyle = TextStyle(
                            fontFamily = zk,
                            fontSize = 18.sp,
                            color = four
                        ), placeholder = {
                            Text(
                                "АДРЕСС",
                                color = three,
                                fontFamily = zk,
                                fontSize = 24.sp,
                            )
                        }, colors = TextFieldDefaults.colors(
                            cursorColor = three,
                            focusedContainerColor = two,
                            unfocusedContainerColor = two,
                            focusedIndicatorColor = four,
                            unfocusedIndicatorColor = four
                        )
                    )
                }

                Button(
                    modifier = Modifier,
                    onClick = {
                        navController.navigate("brand")
                    },
                    border = BorderStroke(
                        width = 2.dp,
                        color = four),
                    colors = ButtonDefaults.buttonColors(two),
                    shape = RoundedCornerShape(
                        30.dp, 30.dp, 30.dp, 0.dp
                    )
                ) {
                    Text(
                        text = "БРЕНД",
                        modifier = Modifier,
                        fontFamily = zk,
                        color = four,
                        fontSize = 24.sp
                    )
                }

                Button(
                    modifier = Modifier,
                    onClick = {
                        navController.navigate("order")
                    },
                    border = BorderStroke(
                        width = 2.dp,
                        color = four),
                    colors = ButtonDefaults.buttonColors(two),
                    shape = RoundedCornerShape(
                        30.dp, 30.dp, 30.dp, 0.dp
                    )
                ) {
                    Text(
                        text = "МОИ ЗАКАЗЫ",
                        modifier = Modifier,
                        fontFamily = zk,
                        color = four,
                        fontSize = 24.sp
                    )
                }

                TextButton(
                    modifier = Modifier,
                    onClick = {
                    }
                ) {
                    Text(
                        text = "восстановить пароль",
                        modifier = Modifier,
                        fontFamily = zk,
                        color = four,
                        fontSize = 24.sp
                    )
                }

                TextButton(
                    modifier = Modifier,
                    onClick = {
                        navController.navigate("applicationinfo")
                    }
                ) {
                    Text(
                        text = "о приложении",
                        modifier = Modifier,
                        fontFamily = zk,
                        color = four,
                        fontSize = 24.sp
                    )
                }
            }
        }
    }
}