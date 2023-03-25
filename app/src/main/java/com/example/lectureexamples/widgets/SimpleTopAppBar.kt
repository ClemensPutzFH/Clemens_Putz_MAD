package com.example.lectureexamples.widgets

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SimpleTopAppBar(text: String, navController : NavHostController) {
    TopAppBar(
        elevation = 4.dp,
        title = {
            Text(text)
        },
        backgroundColor = MaterialTheme.colors.primarySurface, navigationIcon = {
            IconButton(onClick = {
                navController.navigate("homescreen")
            }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        })
}