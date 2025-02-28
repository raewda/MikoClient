package com.example.miko.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.miko.dcl.Orders
import com.example.miko.ui.theme.four
import com.example.miko.ui.theme.one
import com.example.miko.ui.theme.two
import com.example.miko.ui.theme.zk

@Composable
fun Order(
    navController : NavHostController,
    order : MutableState<Boolean>
) {

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = one
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
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
                        modifier = Modifier,
                        fontFamily = zk,
                        fontSize = 20.sp,
                        color = four
                    )
                }
            }

            Text(
                text = "МОИ ЗАКАЗЫ",
                modifier = Modifier
                    .padding(vertical = 10.dp),
                fontFamily = zk,
                fontSize = 40.sp,
                color = four
            )

            LazyColumn(
                modifier = Modifier
            ) {

                items(Orders.ordersAll){ item ->
                    if (item != null){
                        ordersList(item)
                }
                }
            }
        }
    }
}

@Composable
fun ordersList(
    item: Orders,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
            .padding(horizontal = 15.dp)
            .height(100.dp),
        colors = CardDefaults.cardColors(two),
        shape = RoundedCornerShape(
            30.dp, 30.dp, 30.dp, 30.dp
        ),
        border = BorderStroke(
            width = 2.dp,
            color = four
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(vertical = 5.dp)
                .padding(horizontal = 15.dp),
            horizontalArrangement = Arrangement.Absolute.SpaceAround
        ) {

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(60F, true)
            ) {
                Text(
                    text = item.orderName,
                    fontSize = 20.sp,
                    fontFamily = zk,
                    color = four,
                    modifier = Modifier,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            }

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(30F, true)
            ) {
                Text(
                    text = item.orderTransport.toString(),
                    fontSize = 20.sp,
                    fontFamily = zk,
                    color = four,
                    modifier = Modifier,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(20F, true)
            ) {
                Text(
                    text = item.orderStatus.toString(),
                    fontSize = 20.sp,
                    fontFamily = zk,
                    color = four,
                    modifier = Modifier,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
    }
}