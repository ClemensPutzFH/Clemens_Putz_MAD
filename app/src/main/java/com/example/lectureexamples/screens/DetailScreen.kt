package com.example.lectureexamples.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lectureexamples.MovieViewModel
import com.example.lectureexamples.models.getMovies
import com.example.lectureexamples.widgets.MovieRow
import com.example.lectureexamples.widgets.SimpleTopAppBar

@Composable
fun DetailScreen(navController: NavHostController, movieId: String?, movieViewModel: MovieViewModel) {
    Column() {
        SimpleTopAppBar(text = "Movies", navController = navController)


        movieViewModel.moviesList.find{it.id == movieId}?.let {
            MovieRow(movie = it )}

        movieViewModel.moviesList.find{it.id == movieId}?.let {
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