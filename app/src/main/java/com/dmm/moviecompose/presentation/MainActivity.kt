package com.dmm.moviecompose.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dmm.moviecompose.presentation.movie_detail.components.MovieDetailScreen
import com.dmm.moviecompose.presentation.movies.component.MovieScreen
import com.dmm.moviecompose.presentation.util.Screen
import com.dmm.moviecompose.ui.theme.MoviewComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			MoviewComposeTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
					val navController = rememberNavController()
					NavHost(
						navController = navController,
						startDestination = Screen.MovieScreen.route
					) {
						composable(route = Screen.MovieScreen.route) {
							MovieScreen(navController)
						}
						composable(
							route = Screen.MovieDetail.route + "?movieId={movieId}",
							arguments = listOf(
								navArgument(name = "movieId") {
									type = NavType.IntType
									defaultValue = -1
								}
							)
						) {
							MovieDetailScreen(navController)
						}
					}
				}
			}
		}
	}
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	MoviewComposeTheme {
		//MovieScreen()
	}
}