package com.dmm.moviecompose.domain.use_case

import com.dmm.moviecompose.data.model.MovieGenre
import com.dmm.moviecompose.domain.repository.MovieRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class GetGenreMovies(
	val repository: MovieRepository
) {

	@OptIn(DelicateCoroutinesApi::class)
	suspend operator fun invoke(): List<MovieGenre> = GlobalScope.async {
		return@async repository.getMoviesGenre().genres
	}.await()

}