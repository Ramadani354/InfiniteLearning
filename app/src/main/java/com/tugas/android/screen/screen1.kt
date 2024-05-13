package com.tugas.android.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tugas.android.data.names
import com.tugas.android.data.imageId


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun screen1(navController: NavHostController) {
    Scaffold(
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = { navController.navigate("screen1") }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = ""
                        )
                    }
                    IconButton(onClick = { navController.navigate("screen2") }) {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = ""
                        )
                    }
                    IconButton(onClick = { navController.navigate("screen3") }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = ""
                        )
                    }
                }
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Screen 1")
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = LightGray)
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize()
        ) {
            val ItemCount = imageId.size
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.padding(top = 50.dp)
            ) {
                items(ItemCount) { item ->
                    RowItem(
                        itemIndex = item,
                        painter = imageId,
                        tittle = names,
                        navController = navController
                    )
                }
            }

            Divider()
            LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp))
            {
                items(ItemCount) { item ->
                    ColumnItem(
                        itemIndex = item,
                        painter = imageId,
                        tittle = names,
                        navController = navController

                    )
                }
            }
        }
    }
}

@Composable
fun RowItem(
    itemIndex: Int,
    painter: Array<Int>,
    tittle: Array<String>,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "detail/$itemIndex")
            }, colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(painter = painterResource(id = painter[itemIndex]),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .clickable {
                        navController.navigate(route = "detail/$itemIndex")
                    })
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = tittle[itemIndex],
                    fontSize = 16.sp
                )
            }
        }
    }


}

@Composable
fun ColumnItem(
    itemIndex: Int,
    painter: Array<Int>,
    tittle: Array<String>,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "detail/$itemIndex")
            }, colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(4.dp)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = tittle[itemIndex],
                modifier = Modifier.size(100.dp),

                )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = tittle[itemIndex],
                    fontSize = 16.sp
                )
            }
        }
    }
}