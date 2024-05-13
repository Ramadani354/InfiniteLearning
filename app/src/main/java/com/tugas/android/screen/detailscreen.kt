package com.tugas.android.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun detail(photos:Array<Int>,
           name:Array<String>,
           ingridients:Array<String>,
           itemIndex:Int?,
           navController: NavHostController
) {
    Scaffold(
        topBar ={
            TopAppBar(title = {
                Box(modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Detail")

                }
            },
                navigationIcon =  {
                    TextButton(onClick = { navController.navigate("screen1") }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Icon Back")
                        Text(text = "Back")

                    }
                }
            )
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = name[itemIndex!!],
                fontSize = 40.sp,
                textAlign = TextAlign.Center)
            Box(modifier = Modifier.fillMaxWidth()
                , Alignment.TopCenter){
                Image(painter = painterResource(id = photos[itemIndex!!]),
                    contentDescription =name[itemIndex],
                    modifier = Modifier.size(300.dp))
            }

            Divider()
            Text(text = ingridients[itemIndex],
                fontSize = 18.sp)
        }
    }

}