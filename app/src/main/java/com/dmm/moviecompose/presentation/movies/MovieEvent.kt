package com.dmm.moviecompose.presentation.movies

import com.dmm.moviecompose.domain.util.MovieOrder

sealed class MovieEvent {
	data class Order(val movieOrder: MovieOrder): MovieEvent()
	data class SelectGenre(val genreId: Int): MovieEvent()
}
