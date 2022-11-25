package com.dmm.moviecompose.presentation.movie_detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dmm.moviecompose.presentation.movie_detail.MovieDetailViewModel
import com.dmm.moviecompose.ui.theme.MoviewComposeTheme


@Composable
fun MovieDetailScreen(
	navController: NavController,
	viewModel: MovieDetailViewModel = hiltViewModel()
) {
	val state = viewModel.state.value
	val movieDetail = state.movieDetail
	Box() {
		MainPhotoCard(backdropPath = movieDetail.backdropPath!!) {
			navController.navigateUp()
		}
		DescriptionCard(
			title = movieDetail.title,
			overView = movieDetail.overView,
			releaseDate = movieDetail.releaseDate,
			genreList = movieDetail.genres,
			voteAverage = movieDetail.voteAverage
		)

	}
}

@Preview(showSystemUi = true,showBackground = true)
@Composable
fun defaultPreview() {
	MoviewComposeTheme() {
		//MovieDetailScreen()
	}
}