package com.dmm.moviecompose.presentation.movies

import com.dmm.moviecompose.data.model.AudiovisualModel
import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.domain.util.MovieOrder

data class MovieState(
	val movies: List<AudiovisualModel> = emptyList(),
	val genres: List<Genre> = emptyList(),
	val movieOrder: MovieOrder = MovieOrder.Popular()
)
