package com.example.lectureexamples.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lectureexamples.models.getMovies
import com.example.lectureexamples.widgets.MovieRow
import com.example.lectureexamples.widgets.SimpleTopAppBar

@Composable
fun FavoritScreen(navController: NavHostController) {
    Column() {
        SimpleTopAppBar(text = "Favorit Movies", navController = navController)

        LazyColumn(){

            items(getMovies().subList(0,3)) { movie ->
                MovieRow(movie = movie){
                        movieId -> navController.navigate("detailscreen/$movieId")
                }
            }
        }

    }


}