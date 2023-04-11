package com.example.lectureexamples.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lectureexamples.MovieUI
import com.example.lectureexamples.MovieViewModel
import com.example.lectureexamples.models.getMovies
import com.example.lectureexamples.widgets.MovieRow
import com.example.lectureexamples.widgets.SimpleTopAppBar


@Composable
fun AddMovieScreen(navController: NavHostController, movieViewModel: MovieViewModel) {
    val regex = Regex("[^0-9]")
    val lastMovieIdString = regex.replace(movieViewModel.moviesList.last().id, "")
    var data: AddMovieData = AddMovieData("tt" + (lastMovieIdString.toInt() + 1).toString());

    var isButtonEnabled by remember {
        mutableStateOf(false)
    }
    Column() {
        SimpleTopAppBar(text = "Add Movie", navController = navController)

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            Column() {


                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    value = data.title,
                    onValueChange = { value ->
                        data.title = value; isButtonEnabled = isDataFilledIn(data = data)
                    },
                    label = { Text(text = "Title") })
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    value = data.year,
                    onValueChange = { value ->
                        data.year = value; isButtonEnabled = isDataFilledIn(data = data)
                    },
                    label = { Text(text = "Year") })
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    value = data.director,
                    onValueChange = { value ->
                        data.director = value; isButtonEnabled = isDataFilledIn(data = data)
                    },
                    label = { Text(text = " Director") })
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    value = data.actors,
                    onValueChange = { value ->
                        data.actors = value; isButtonEnabled = isDataFilledIn(data = data)
                    },
                    label = { Text(text = " Actors") })
                OutlinedTextField(modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                    value = data.plot,
                    onValueChange = { value -> data.plot = value },
                    label = { Text(text = " Plot") })
                OutlinedTextField(modifier = Modifier.fillMaxWidth(),
                    value = data.rating,
                    onValueChange = { value ->
                        data.rating = value; isButtonEnabled = isDataFilledIn(data = data)
                    },
                    label = { Text(text = " Rating") })


                Button(onClick = {
                    movieViewModel.moviesList.add(
                        MovieUI(
                            id = data.id,
                            initalFav = false,
                            title = data.title,
                            year = data.year,
                            genre = "not available yet",
                            director = data.director,
                            actors = data.actors,
                            plot = data.plot,
                            images = listOf("https://digitalfinger.id/wp-content/uploads/2019/12/no-image-available-icon-6.png"),
                            rating = data.rating
                        )
                    )

                    navController.navigate("homescreen")
                }, enabled = isButtonEnabled) {
                    Text(text = "Add Movie")
                }
            }
        }

    }


}


fun isDataFilledIn(data: AddMovieData): Boolean {
    return data.title.isNotBlank() &&
            data.year.isNotBlank() &&
            data.director.isNotBlank() &&
            data.actors.isNotBlank() &&
            data.rating.isNotBlank()

}


data class AddMovieData(val id: String) {

    var title by mutableStateOf("")

    var year by mutableStateOf("")

    var director by mutableStateOf("")

    var actors by mutableStateOf("")

    var plot by mutableStateOf("")

    var rating by mutableStateOf("")
}