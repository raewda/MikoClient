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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.miko.R
import com.example.miko.dcl.Orders
import com.example.miko.ui.theme.four
import com.example.miko.ui.theme.one
import com.example.miko.ui.theme.three
import com.example.miko.ui.theme.two
import com.example.miko.ui.theme.zk

@Composable
fun Katalog(
    navController : NavHostController,
    katalog : MutableState<Boolean>
){
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
                                navController.navigate("katalog")
                            },
                            border = BorderStroke(
                                width = 2.dp,
                                color = four
                            ),
                            colors = ButtonDefaults.buttonColors(two),
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
                            colors = ButtonDefaults.buttonColors(Color.Transparent),
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
                .padding(innerPadding),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "ПРЕДЛОЖЕНИЯ",
                    fontFamily = zk,
                    fontSize = 40.sp,
                    color = four
                )
            }

            LazyRow(
                modifier = Modifier
            ) {
                items(Orders.ordersAll){ item ->
                    if (item != null){
                        offersList(item, navController)
                    }
                }
            }
        }
    }
}

@Composable
fun offersList(
    item: Orders,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(vertical = 5.dp)
            .padding(horizontal = 25.dp)
            .height(550.dp)
            .width(300.dp),
        colors = CardDefaults.cardColors(two),
        shape = RoundedCornerShape(
            30.dp, 30.dp, 30.dp, 30.dp
        ),
        border = BorderStroke(
            width = 2.dp,
            color = four
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(vertical = 15.dp)
                .padding(horizontal = 15.dp),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(20F, true)
            ) {
                Text(
                    text = item.orderName,
                    fontSize = 24.sp,
                    fontFamily = zk,
                    color = four,
                    modifier = Modifier,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

            }

            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(30F, true)
            ) {
                Image(
                    painter = painterResource(item.orderImage),
                    contentDescription = "offer image",
                    modifier = Modifier
                        .size(300.dp)
                )
            }

            Column(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(40F, true)
            ) {
                Text(
                    text = item.orderCharacter,
                    fontSize = 20.sp,
                    fontFamily = zk,
                    color = four,
                    modifier = Modifier,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Button(
                modifier = Modifier,
                onClick = {
                    navController.navigate("offer/${item.id}")
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
                    text = "ПОДРОБНЕЕ",
                    modifier = Modifier,
                    fontFamily = zk,
                    color = four,
                    fontSize = 24.sp
                )
            }

        }
    }
}