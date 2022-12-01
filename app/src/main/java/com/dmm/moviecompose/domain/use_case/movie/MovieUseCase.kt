package com.dmm.moviecompose.domain.use_case.movie

data class MovieUseCase(
	val getMovies: GetMovies,
	val getGenreMovies: GetGenreMovies,
	val getMovieDetail: GetMovieDetail
)