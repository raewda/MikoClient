package com.example.miko.screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun Registration(
    navController: NavHostController,
    registration: MutableState<Boolean>,
) {
    val loginUser = remember { mutableStateOf("") }
    val passwordUser = remember { mutableStateOf("") }
    val companyCode = remember { mutableStateOf("") }
    val emailUser = remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    val context = LocalContext.current

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
                text = "РЕГИСТРАЦИЯ",
                modifier = Modifier
                    .padding(vertical = 10.dp),
                fontFamily = zk,
                fontSize = 40.sp,
                color = four
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    OutlinedTextField(
                        value = TextFieldValue("КОД БРЕНДА"),
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
                        value = companyCode.value, onValueChange = { new ->
                            companyCode.value = new.uppercase()
                        },
                        modifier = Modifier,
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 0.dp, 30.dp
                        ),
                        enabled = true,
                        readOnly = false,
                        textStyle = TextStyle(
                            fontFamily = zk,
                            fontSize = 24.sp,
                            color = four
                        ), placeholder = {
                            Text(
                                "ВВЕСТИ КОД",
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
                        value = "EMAIL",
                        onValueChange = {},
                        modifier = Modifier,
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 30.dp, 0.dp
                        ),
                        enabled = false,
                        readOnly = true,
                        textStyle = TextStyle(
                            fontFamily = zk, fontSize = 24.sp, color = four
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
                        value = emailUser.value,
                        onValueChange = { new ->
                            emailUser.value = new.uppercase()
                        },
                        modifier = Modifier,
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 0.dp, 30.dp
                        ),
                        enabled = true,
                        readOnly = false,
                        textStyle = TextStyle(
                            fontFamily = zk,
                            fontSize = 24.sp,
                            color = four
                        ), placeholder = {
                            Text(
                                "ВВЕСТИ EMAIL",
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
                    modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End
                ) {
                    OutlinedTextField(
                        value = loginUser.value,
                        onValueChange = { new ->
                            loginUser.value = new.uppercase()
                        },
                        modifier = Modifier,
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 0.dp, 30.dp
                        ),
                        enabled = true,
                        readOnly = false,
                        textStyle = TextStyle(
                            fontFamily = zk,
                            fontSize = 24.sp,
                            color = four
                        ), placeholder = {
                            Text(
                                "ВВЕСТИ ЛОГИН",
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
                        value = passwordUser.value, onValueChange = { new ->
                            passwordUser.value = new.uppercase()
                        },
                        modifier = Modifier,
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 0.dp, 30.dp
                        ),
                        enabled = true,
                        readOnly = false,
                        textStyle = TextStyle(
                            fontFamily = zk,
                            fontSize = 24.sp,
                            color = four
                        ), placeholder = {
                            Text(
                                "ВВЕСТИ ПАРОЛЬ",
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
            }

            Button(
                shape = RoundedCornerShape(
                    30.dp, 30.dp, 30.dp, 30.dp
                ),
                modifier = Modifier
                    .padding(top = 20.dp),
                onClick = {
                    if (checked){
                        navController.navigate("start")
                    }
                    else{
                        Toast.makeText(context, "privacy policy not accepted", Toast.LENGTH_SHORT).show()
                    }
                },
                border = BorderStroke(
                    width = 2.dp, color = four
                ),
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

            Row(
            ) {

                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    modifier = Modifier,
                    colors = CheckboxDefaults.colors(
                        checkedColor = four,
                        uncheckedColor = four,
                        checkmarkColor = one
                    )
                )

                TextButton(modifier = Modifier, onClick = {

                }
                ) {
                    Text(
                        text = "принять политику конфиденциальности приложения",
                        modifier = Modifier,
                        fontFamily = zk,
                        color = four,
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}
