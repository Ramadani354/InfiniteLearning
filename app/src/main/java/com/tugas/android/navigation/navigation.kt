package com.tugas.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.tugas.android.data.imageId
import com.tugas.android.data.ingredients
import com.tugas.android.data.names
import com.tugas.android.screen.detail
import com.tugas.android.screen.screen1
import com.tugas.android.screen.screen2
import com.tugas.android.screen.screen3

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "screen1") {

        composable(route = "screen1") {
            screen1(navController)
        }
        composable(route = "screen2") {
            screen2(navController)
        }
        composable(route = "screen3") {
            screen3(navController)
        }
        composable(route = "detail/{index}",
            arguments = listOf(
                navArgument(name = "index"){
                    type = NavType.IntType
                }
            )) {index ->
            detail(photos = imageId,
                name = names,
                ingridients = ingredients,
                itemIndex = index.arguments?.getInt("index"),
                navController
            )
        }
    }
}