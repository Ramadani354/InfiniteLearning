package com.tugas.android.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tugas.android.data.imageId
import com.tugas.android.data.names

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun screen2(navController: NavHostController) {
    Scaffold (
        bottomBar = {
            BottomAppBar {
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround) {
                    IconButton(onClick = { navController.navigate("screen1")}) {
                        Icon(imageVector = Icons.Default.Home,
                            contentDescription = "")
                    }
                    IconButton(onClick = { navController.navigate("screen2")}) {
                        Icon(imageVector = Icons.Default.List,
                            contentDescription = "")
                    }
                    IconButton(onClick = { navController.navigate("screen3")}) {
                        Icon(imageVector = Icons.Default.AccountCircle,
                            contentDescription = "")
                    }
                }
            }
        },
        topBar ={
            TopAppBar(title = {
                Box(modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center){
                    Text(text = "Screen 2")
                }
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray)
            )
        }
    ){
        LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(top = 70.dp, bottom = 85.dp)) {
            val ItemCount = imageId.size
            items(ItemCount){item ->
                lazyitem(
                    itemIndex = item,
                    painter = imageId,
                    tittle = names,
                    navController = navController

                )
            }
        }
    }


}
@Composable
fun lazyitem(itemIndex: Int,
             painter: Array<Int>,
             tittle: Array<String>,
             navController: NavHostController) {
    Card(modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()
        .clickable {
            navController.navigate(route = "detail/$itemIndex")
        }
        ,colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)) {
        Column(modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = painter[itemIndex]),
                contentDescription = tittle[itemIndex],
                modifier = Modifier.size(140.dp)
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