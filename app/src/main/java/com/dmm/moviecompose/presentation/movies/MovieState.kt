package com.dmm.moviecompose.presentation.movies

import com.dmm.moviecompose.data.model.Movie
import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.domain.util.MovieOrder

data class MovieState(
	val movies: List<Movie> = emptyList(),
	val genres: List<Genre> = emptyList(),
	val movieOrder: MovieOrder = MovieOrder.Popular()
)
