package com.example.lectureexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lectureexamples.models.Movie
import com.example.lectureexamples.screens.DetailScreen
import com.example.lectureexamples.screens.FavoritScreen
import com.example.lectureexamples.screens.HomeScreen
import com.example.lectureexamples.widgets.myNavigation

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            myNavigation()
        }
    }


}
