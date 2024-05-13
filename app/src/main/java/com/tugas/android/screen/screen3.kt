package com.tugas.android.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Divider
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tugas.android.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun screen3(navController: NavHostController) {
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
                    Text(text = "About Me")
                }
            },
                colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.LightGray)
            )
        }
    ){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.Start) {
            Box(modifier = Modifier.fillMaxWidth(),
                Alignment.TopCenter){
                Image(painter = painterResource(id = R.drawable.foto_profile),
                    contentDescription ="foto",
                    modifier = Modifier
                        .size(400.dp)
                        .padding(top = 80.dp, bottom = 16.dp))
            }
            Divider()

            Text(text = "Nama : Yovi Adhi Ramadani",
                fontSize = 18.sp)

            Text(text = "Email : yoviadhi123@gmail.com",
                fontSize = 18.sp)
            Text(text = "Studi : Universitas Semarang",
                fontSize = 18.sp,
                textAlign = TextAlign.Center)
            Text(text = "Program Studi : S1-Teknik Informatika",
                fontSize = 18.sp)

        }

    }
}