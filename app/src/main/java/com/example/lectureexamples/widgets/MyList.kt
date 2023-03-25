package com.example.lectureexamples.widgets

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.models.getMovies

@Composable
fun MyList(movies: List<Movie> = getMovies(), navController: NavHostController){

    LazyColumn(){

        items(movies) {movie ->
            MovieRow(movie = movie){
                    movieId -> navController.navigate("detailscreen/$movieId")
            }
        }
    }
}