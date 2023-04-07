package com.example.lectureexamples.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.lectureexamples.MovieViewModel
import com.example.lectureexamples.models.getMovies
import com.example.lectureexamples.widgets.MovieRow
import com.example.lectureexamples.widgets.SimpleTopAppBar

@Composable
fun FavoritScreen(navController: NavHostController, movieViewModel: MovieViewModel) {
    Column() {
        SimpleTopAppBar(text = "Favorit Movies", navController = navController)

        LazyColumn(){

            items(movieViewModel.moviesList.filter { it.fav }) { movie ->
                MovieRow(movie = movie){
                        movieId -> navController.navigate("detailscreen/$movieId")
                }
            }
        }

    }


}