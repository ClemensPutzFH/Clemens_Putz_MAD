package com.example.lectureexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.lectureexamples.models.getMovies
import com.example.lectureexamples.widgets.myNavigation

class MainActivity : ComponentActivity() {

    protected val movieViewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            myNavigation(movieViewModel)
        }
    }

}

class MovieViewModel : ViewModel() {

     var moviesList: MutableList<MovieUI> = getMovies().map {
        MovieUI(
            id = it.id,
            initalFav = false,
            title = it.title,
            year = it.year,
            genre = it.genre,
            director = it.director,
            actors = it.actors,
            plot = it.plot,
            images = it.images,
            rating = it.rating
        )
    }.toMutableStateList();

    val movies: List<MovieUI>
        get() = moviesList

    //var movies by mutableStateOf(moviesList);
}

data class MovieUI(
    val id: String,
    var initalFav: Boolean,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val images: List<String>,
    val rating: String
){
    var fav: Boolean by mutableStateOf(initalFav)
}
