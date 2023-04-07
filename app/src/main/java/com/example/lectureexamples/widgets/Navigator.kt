package com.example.lectureexamples.widgets

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lectureexamples.MovieViewModel
import com.example.lectureexamples.screens.DetailScreen
import com.example.lectureexamples.screens.FavoritScreen
import com.example.lectureexamples.screens.HomeScreen

@Composable
fun myNavigation(movieViewModel: MovieViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "homescreen" ){
        composable("homescreen"){ HomeScreen(navController = navController, movieViewModel = movieViewModel) }
        composable("detailscreen/{movieId}", arguments = listOf(navArgument("movieId"){
            type = NavType.StringType
        })
        ) {backStackEntry ->
            DetailScreen(navController, movieId = backStackEntry.arguments?.getString("movieId"), movieViewModel = movieViewModel)
        }
        composable("favoritscreen"){ FavoritScreen(navController = navController, movieViewModel = movieViewModel) }
    }
}