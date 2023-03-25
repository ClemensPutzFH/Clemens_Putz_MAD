package com.example.lectureexamples.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.models.getMovies
import com.example.lectureexamples.widgets.MovieRow
import com.example.lectureexamples.widgets.SimpleTopAppBar

@Composable
fun DetailScreen(navController: NavHostController, movieId: String?) {
    Column() {
        SimpleTopAppBar(text = "Movies", navController = navController)

        getMovies().find{it.id == movieId}?.let {
            MovieRow(movie = it )}

        getMovies().find{it.id == movieId}?.let {
            LazyRow(){
                items(it.images){
                    imageLink ->
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(imageLink)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }}


    }


}