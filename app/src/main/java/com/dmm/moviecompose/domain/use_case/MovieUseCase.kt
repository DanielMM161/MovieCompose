package com.dmm.moviecompose.domain.use_case

data class MovieUseCase(
	val getMovies: GetMovies,
	val getGenreMovies: GetGenreMovies
)