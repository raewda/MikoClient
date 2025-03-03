package com.example.miko.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import android.content.res.Resources
import androidx.compose.ui.unit.Dp
import kotlin.math.roundToInt
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.example.miko.R
import com.example.miko.dcl.Orders
import com.example.miko.ui.theme.four
import com.example.miko.ui.theme.one
import com.example.miko.ui.theme.three
import com.example.miko.ui.theme.two
import com.example.miko.ui.theme.zk

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Buy(
    navController: NavHostController,
    buy: MutableState<Boolean>,
    item : Orders
) {

    val openInfoDialog = remember { mutableStateOf(false) }
    val openBuyDialog = remember { mutableStateOf(false) }

    val orderBuyCode = remember { mutableStateOf(TextFieldValue(item.orderCode.toString())) }
    val orderBuyTransport = remember { mutableStateOf(TextFieldValue(item.orderTransport.toString())) }
    val numberTelephone = remember { mutableStateOf("") }

    val openMenu = remember { mutableStateOf(false) }
//    val offsetMenu = remember { mutableStateOf(Offset(0F,0F)) }
    val bankPick = remember { mutableStateOf("ВЫБРАТЬ БАНК") }

    val banksNames = listOf(
        "ВТБ", "СберБанк", "ГАЗПРОМБАНК", "Альфа Банк"
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = one
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .padding(horizontal = 15.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextButton(
                    modifier = Modifier,
                    onClick = {
                    navController.navigateUp()
                }) {
                    Text(
                        text = "назад",
                        modifier = Modifier,
                        fontFamily = zk,
                        fontSize = 20.sp,
                        color = four
                    )
                }

                Column(
                    modifier = Modifier,
                    verticalArrangement = Arrangement.Center
                ) {
                    IconButton(
                        modifier = Modifier
                            .size(20.dp),
                        onClick = {
                            openInfoDialog.value = true
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

                if (openInfoDialog.value){
                    Dialog(
                        onDismissRequest = {
                            openInfoDialog.value = false
                        },
                        properties = DialogProperties(
                            usePlatformDefaultWidth = false
                        )
                    ){
                        Card(
                            modifier = Modifier
                                .verticalScroll(rememberScrollState())
                                .size(300.dp, 500.dp)
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(one),
                            shape = RoundedCornerShape(
                                30.dp, 30.dp, 30.dp, 30.dp
                            ),
                            border = BorderStroke(
                                width = 2.dp,
                                color = four)
                        ) {
                            Text(
                                text = "УСЛОВИЯ ЗАКАЗА",
                                color = four,
                                fontFamily = zk,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )

                            OutlinedTextField(
                                value = TextFieldValue(stringResource(R.string.application_info)),
                                onValueChange = {},
                                modifier = Modifier
                                    .padding(top = 20.dp)
                                    .padding(horizontal = 20.dp)
                                    .size(350.dp),
                                shape = RoundedCornerShape(
                                    30.dp, 30.dp, 30.dp, 0.dp
                                ),
                                enabled = false,
                                readOnly = true,
                                textStyle = TextStyle(
                                    fontFamily = zk,
                                    fontSize = 20.sp,
                                    color = four
                                ),
                                colors = TextFieldDefaults.colors(
                                    focusedIndicatorColor = four,
                                    unfocusedIndicatorColor = four,
                                    disabledContainerColor = two
                                )
                            )

                            Button(
                                shape = RoundedCornerShape(
                                    30.dp, 30.dp, 30.dp, 30.dp
                                ),
                                modifier = Modifier
                                    .size(80.dp, 70.dp)
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp)
                                    .align(Alignment.CenterHorizontally),
                                onClick = {
                                    openInfoDialog.value = false
                                },
                                border = BorderStroke(
                                    width = 2.dp,
                                    color = four
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
                        }
                    }
                }
            }

            Text(
                text = "ЗАКАЗАТЬ",
                fontFamily = zk,
                fontSize = 40.sp,
                color = four
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp)
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
                        value = TextFieldValue("АРТИКУЛ"),
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
                        value = orderBuyCode.value,
                        onValueChange = { new ->
                            orderBuyCode.value = new
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
                        placeholder = {
                            Text(
                                text = "ВВЕСТИ АРТИКУЛ",
                                color = three,
                                fontFamily = zk,
                                fontSize = 24.sp,
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            cursorColor = three,
                            focusedContainerColor = two,
                            unfocusedContainerColor = two,
                            focusedIndicatorColor = four,
                            unfocusedIndicatorColor = four
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)

                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    OutlinedTextField(
                        value = "НОМЕР ТЕЛЕФОНА",
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
                        value = numberTelephone.value,
                        onValueChange = { new ->
                            numberTelephone.value = new
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
                        placeholder = {
                            Text(
                                "ВВЕСТИ НОМЕР",
                                color = three,
                                fontFamily = zk,
                                fontSize = 24.sp,
                            )
                        },
                        colors = TextFieldDefaults.colors(
                            cursorColor = three,
                            focusedContainerColor = two,
                            unfocusedContainerColor = two,
                            focusedIndicatorColor = four,
                            unfocusedIndicatorColor = four
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    OutlinedTextField(
                        value = "МОБИЛЬНЫЙ БАНК",
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
                    Button(
                        modifier = Modifier,
//                            .onGloballyPositioned { offsetMenu.value = it.positionInRoot()},
                        onClick = {
                            openMenu.value = true
                        },
                        border = BorderStroke(
                            width = 2.dp,
                            color = four),
                        colors = ButtonDefaults.buttonColors(three),
                        shape = RoundedCornerShape(
                            30.dp, 30.dp, 0.dp, 30.dp
                        )
                    ) {
                        Text(
                            text = bankPick.value,
                            fontFamily = zk,
                            color = two,
                            fontSize = 22.sp
                        )
                    }
                }

                if (openMenu.value){
                    DropdownMenu(
                        modifier = Modifier
                            .background(four),
//                            .offset(offsetMenu.value.x.pxToDp(), offsetMenu.value.y.pxToDp()),
                        expanded = openMenu.value,
                        onDismissRequest = { openMenu.value = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text(
                                text = banksNames.component1(),
                                fontFamily = zk,
                                color = two,
                                fontSize = 22.sp
                            ) },
                            onClick = {
                                bankPick.value = banksNames.component1()
                                openMenu.value = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(
                                text = banksNames.component2(),
                                fontFamily = zk,
                                color = two,
                                fontSize = 22.sp
                            ) },
                            onClick = {
                                bankPick.value = banksNames.component2()
                                openMenu.value = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(
                                text = banksNames.component3(),
                                fontFamily = zk,
                                color = two,
                                fontSize = 22.sp
                            ) },
                            onClick = {
                                bankPick.value = banksNames.component3()
                                openMenu.value = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text(
                                text = banksNames.component4(),
                                fontFamily = zk,
                                color = two,
                                fontSize = 22.sp
                            ) },
                            onClick = {
                                bankPick.value = banksNames.component4()
                                openMenu.value = false
                            }
                        )
                    }
                }

                Button(
                    modifier = Modifier,
                    onClick = {
                        openBuyDialog.value = true
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

                if (openBuyDialog.value){
                    Dialog(
                        onDismissRequest = {
                            openBuyDialog.value = false
                        },
                        properties = DialogProperties(
                            usePlatformDefaultWidth = false
                        )
                    ){
                        Card(
                            modifier = Modifier
                                .verticalScroll(rememberScrollState())
                                .size(300.dp, 450.dp)
                                .fillMaxWidth(),
                            colors = CardDefaults.cardColors(one),
                            shape = RoundedCornerShape(
                                30.dp, 30.dp, 30.dp, 30.dp
                            ),
                            border = BorderStroke(
                                width = 2.dp,
                                color = four)
                        ) {
                            Text(
                                text = "ЗАКАЗАТЬ",
                                color = four,
                                fontFamily = zk,
                                fontSize = 20.sp,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )

                            Column(
                                modifier = Modifier
                                    .padding(horizontal = 10.dp),
                                horizontalAlignment = Alignment.Start,
                                verticalArrangement = Arrangement.spacedBy(15.dp)
                            ) {
                                OutlinedTextField(
                                    value = orderBuyCode.value,
                                    onValueChange = {},
                                    modifier = Modifier
                                        .padding(top = 10.dp),
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

                                OutlinedTextField(
                                    value = orderBuyTransport.value,
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

                                OutlinedTextField(
                                    value = numberTelephone.value,
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

                                OutlinedTextField(
                                    value = bankPick.value,
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

                            Button(
                                shape = RoundedCornerShape(
                                    30.dp, 30.dp, 30.dp, 30.dp
                                ),
                                modifier = Modifier
                                    .size(80.dp, 70.dp)
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp)
                                    .align(Alignment.CenterHorizontally),
                                onClick = {
                                    // добавление заказа в бд
                                    openBuyDialog.value = false
                                    navController.navigateUp()
                                },
                                border = BorderStroke(
                                    width = 2.dp,
                                    color = four
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
                        }
                    }
                }
            }
        }
    }
}


//fun Float.pxToDp(): Dp {
//    val density = Resources.getSystem().displayMetrics.density
//    return (this / density).roundToInt().dp
//}
