package com.dmm.moviecompose.presentation.movies.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.UiComposable
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.dmm.moviecompose.domain.util.MovieOrder
import com.dmm.moviecompose.presentation.movies.MovieEvent
import com.dmm.moviecompose.presentation.movies.MovieViewModel
import com.dmm.moviecompose.presentation.util.Screen

@Composable
fun MovieScreen(
	navController: NavController,
	viewModel: MovieViewModel = hiltViewModel()
) {
	val state = viewModel.state.value

	Box(
		modifier = Modifier.fillMaxSize()
	) {
		Column(
			modifier = Modifier
				.fillMaxSize(),
		) {
			ChipSection(genreList = state.genres) {
				viewModel.onEvent(
					MovieEvent.SelectGenre(it)
				)
				val order = MovieEvent.Order(
					MovieOrder.Genre(viewModel.state.value.genres.filter { it.isSelected }.map { it.genre_id })
				)
				viewModel.onEvent(order)
			}
			LazyColumn(modifier = Modifier.fillMaxWidth()) {
				items(state.movies) { movie ->
					MovieItem(
						title = movie.title,
						overView = movie.overview,
						posterPath = movie.posterPath!!,
						voteAverage = movie.voteAverage,
						modifier = Modifier
							.fillMaxWidth()
							.padding(start = 44.dp, end = 44.dp)
							.clickable {
								navController.navigate(
									route = Screen.MovieDetail.route + "?movieId=${movie.id}"
								)
							}
					)
					Spacer(modifier = Modifier.height(14.dp))
				}
			}
		}
	}
}
