package com.example.lectureexamples.screens

import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lectureexamples.MovieUI
import com.example.lectureexamples.MovieViewModel
import com.example.lectureexamples.R
import com.example.lectureexamples.models.getMovies
import com.example.lectureexamples.widgets.MovieRow
import com.example.lectureexamples.widgets.SimpleTopAppBar
import java.util.Arrays.asList


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddMovieScreen(navController: NavHostController, movieViewModel: MovieViewModel) {
    val regex = Regex("[^0-9]")
    val lastMovieIdString = regex.replace(movieViewModel.moviesList.last().id, "")
    var data: AddMovieData = AddMovieData("tt" + (lastMovieIdString.toInt() + 1).toString());

    var isButtonEnabled by remember {
        mutableStateOf(false)
    }

    val genres = asList("action", "fun")

    var genreItems by remember {
        mutableStateOf(
            genres.map { genre ->
                ListItemSelectable(
                    title = genre.toString(),
                    isSelected = false
                )
            }
        )
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

                LazyHorizontalGrid(
                    modifier = Modifier.height(100.dp),
                    rows = GridCells.Fixed(3)){
                    items(genreItems) { genreItem ->
                        Chip(
                            modifier = Modifier.padding(2.dp),
                            colors = ChipDefaults.chipColors(
                                backgroundColor = if (genreItem.isSelected)
                                    colorResource(id = R.color.purple_200)
                                else
                                    colorResource(id = R.color.white)
                            ),
                            onClick = {
                                genreItems = genreItems.map {
                                    if (it.title == genreItem.title) {
                                        genreItem.copy(isSelected = !genreItem.isSelected)
                                    } else {
                                        it
                                    }
                                }
                            }
                        ) {
                            Text(text = genreItem.title)
                        }
                    }
                }


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

class ListItemSelectable(var title : String, var isSelected: Boolean){
    fun copy(isSelected: Boolean): ListItemSelectable {
        return ListItemSelectable(title= title, isSelected)
    }
}