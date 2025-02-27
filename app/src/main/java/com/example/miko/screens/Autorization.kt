package com.example.miko.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.miko.ui.theme.four
import com.example.miko.ui.theme.one
import com.example.miko.ui.theme.three
import com.example.miko.ui.theme.two
import com.example.miko.ui.theme.zk

@Composable
fun Autorization(
    navController: NavHostController,
    autorization: MutableState<Boolean>
){
    val loginUser = remember { mutableStateOf("") }
    val passwordUser = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = one
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "АВТОРИЗАЦИЯ",
                fontFamily = zk,
                fontSize = 40.sp,
                color = four
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    OutlinedTextField(
                        value = TextFieldValue("ЛОГИН"),
                        onValueChange = {},
                        modifier = Modifier,
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 30.dp, 0.dp
                        ),
                        enabled = false,
                        readOnly = true,
                        textStyle = TextStyle(
                            fontFamily = zk,
                            fontSize = 24.sp,
                            color = four
                        ),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = four,
                            unfocusedIndicatorColor = four,
                            disabledContainerColor = two
                        )
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    OutlinedTextField(
                        value = loginUser.value,
                        onValueChange = {
                                new -> loginUser.value = new.uppercase()
                        },
                        modifier = Modifier,
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 0.dp, 30.dp
                        ),
                        enabled = true,
                        readOnly = false,
                        singleLine = true,
                        textStyle = TextStyle(
                            fontFamily = zk,
                            fontSize = 24.sp,
                            color = four
                        ),
                        placeholder = { Text("ВВЕСТИ ЛОГИН",
                            color = three,
                            fontFamily = zk,
                            fontSize = 24.sp,) },
                        colors = TextFieldDefaults.colors(
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
                        value = "ПАРОЛЬ",
                        onValueChange = {},
                        modifier = Modifier,
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 30.dp, 0.dp
                        ),
                        enabled = false,
                        readOnly = true,
                        textStyle = TextStyle(
                            fontFamily = zk,
                            fontSize = 24.sp,
                            color = four
                        ),
                        colors = TextFieldDefaults.colors(
                            focusedIndicatorColor = four,
                            unfocusedIndicatorColor = four,
                            disabledContainerColor = two
                        )
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {
                    OutlinedTextField(
                        value = passwordUser.value,
                        onValueChange = {
                                new -> passwordUser.value = new.uppercase()
                        },
                        modifier = Modifier,
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 0.dp, 30.dp
                        ),
                        enabled = true,
                        readOnly = false,
                        singleLine = true,
                        textStyle = TextStyle(
                            fontFamily = zk,
                            fontSize = 24.sp,
                            color = four
                        ),
                        placeholder = { Text("ВВЕСТИ ПАРОЛЬ",
                            color = three,
                            fontFamily = zk,
                            fontSize = 24.sp,) },
                        colors = TextFieldDefaults.colors(
                            cursorColor = three,
                            focusedContainerColor = two,
                            unfocusedContainerColor = two,
                            focusedIndicatorColor = four,
                            unfocusedIndicatorColor = four
                        )
                    )

//                    TextButton(
//                        modifier = Modifier
//                            .align(Alignment.End),
//                        onClick = {
//
//                        }
//                    ) {
//                        Text(
//                            text = "код на почту",
//                            modifier = Modifier,
//                            fontFamily = zk,
//                            fontSize = 18.sp,
//                            color = four
//                        )
//                    }
                }
            }

            Button(
                shape = RoundedCornerShape(
                    30.dp, 30.dp, 30.dp, 30.dp
                ),
                modifier = Modifier,
                onClick = {
                    // переделать
                    navController.navigate("profile")
                },
                border = BorderStroke(
                    width = 2.dp,
                    color = four),
                colors = ButtonDefaults.buttonColors(two)
            ) {
                Text(
                    text = "ОК",
                    modifier = Modifier,
                    fontFamily = zk,
                    color = four,
                    fontSize = 24.sp
                )
            }
        }
    }

}