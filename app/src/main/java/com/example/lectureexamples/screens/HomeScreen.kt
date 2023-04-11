package com.example.lectureexamples.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lectureexamples.ui.theme.LectureExamplesTheme
import com.example.lectureexamples.MovieViewModel
import com.example.lectureexamples.widgets.MyList

@Composable
fun HomeScreen(navController: NavHostController, movieViewModel: MovieViewModel) {
    // state of the menu
    var expanded by remember {
        mutableStateOf(false)
    }

    LectureExamplesTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {


            Column {
                TopAppBar(
                    elevation = 4.dp,
                    title = {
                        Text("Movies")
                    },
                    backgroundColor = MaterialTheme.colors.primarySurface, actions = {
                        Box() {
                            IconButton(onClick = {expanded = true }) {
                                Icon(Icons.Filled.MoreVert, null)
                            }

                            DropdownMenu(
                                expanded = expanded,
                                onDismissRequest = {
                                    expanded = false
                                }){

                                Row(modifier = Modifier.clickable { navController.navigate("favoritscreen") }){

                                    Icon(Icons.Filled.Favorite,null)
                                    Text(text = "Favorits")
                                }

                                Row(modifier = Modifier.clickable { navController.navigate("addMovieScreen") }){

                                    Icon(Icons.Default.Add,null)
                                    Text(text = "Add Movie")
                                }

                            }
                        }

                    })

                Text(
                    style = MaterialTheme.typography.h6,
                    text= "Movie List"
                )
                MyList(navController= navController, movieViewModel = movieViewModel);
            }
            }
    }
}


