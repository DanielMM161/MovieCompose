package com.dmm.moviecompose.presentation.util

sealed class Screen(val route: String) {
	object MovieScreen: Screen("movie_screen")
	object MovieDetail: Screen("movie_detail")
}
