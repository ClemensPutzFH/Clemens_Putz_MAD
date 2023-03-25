package com.example.lectureexamples.widgets

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lectureexamples.screens.DetailScreen
import com.example.lectureexamples.screens.FavoritScreen
import com.example.lectureexamples.screens.HomeScreen

@Composable
fun myNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homescreen" ){
        composable("homescreen"){ HomeScreen(navController = navController) }
        composable("detailscreen/{movieId}", arguments = listOf(navArgument("movieId"){
            type = NavType.StringType
        })
        ) {backStackEntry ->
            DetailScreen(navController, movieId = backStackEntry.arguments?.getString("movieId"))
        }
        composable("favoritscreen"){ FavoritScreen(navController = navController) }
    }
}