package com.example.lectureexamples.screens

import android.service.autofill.OnClickAction
import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.lectureexamples.R
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.models.getMovies
import com.example.lectureexamples.ui.theme.LectureExamplesTheme
import androidx.compose.ui.res.imageResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.lectureexamples.widgets.MovieRow
import com.example.lectureexamples.widgets.MyList

@Composable
fun HomeScreen(navController: NavHostController) {
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

                            }
                        }

                    })

                Text(
                    style = MaterialTheme.typography.h6,
                    text= "Movie List"
                )
                MyList(navController= navController)
            }
            }
    }
}


