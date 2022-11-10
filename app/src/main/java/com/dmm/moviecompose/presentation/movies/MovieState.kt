package com.dmm.moviecompose.presentation.movies

import com.dmm.moviecompose.data.model.Movie
import com.dmm.moviecompose.data.model.MovieGenre
import com.dmm.moviecompose.domain.util.MovieOrder

data class MovieState(
	val movies: List<Movie> = emptyList(),
	val movieGenre: List<MovieGenre> = emptyList(),
	val movieOrder: MovieOrder = MovieOrder.Popular()
)
