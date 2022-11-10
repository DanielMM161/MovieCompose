package com.dmm.moviecompose.domain.use_case

import com.dmm.moviecompose.data.model.Movie
import com.dmm.moviecompose.domain.util.MovieOrder
import com.dmm.moviecompose.domain.repository.MovieRepository
import com.dmm.moviecompose.domain.util.MovieOrder.Genre
import com.dmm.moviecompose.domain.util.MovieOrder.Popular
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetMovies(
	private val repository: MovieRepository
) {

	operator fun invoke(
		movieOrder: MovieOrder = Genre(listOf())
	): Flow<List<Movie>> {
		return repository.getPopularMovies().map { moviesModel ->
			when(movieOrder) {
				is Genre -> {
					moviesModel.movies.filter { movie -> searchGenres(movieOrder.genreIds, movie.genreİds) }
				}
				is Popular -> {
					moviesModel.movies
				}
			}
		}
	}

	private fun searchGenres(genreIds: List<Int>, moviesGenre: List<Int?>?): Boolean {
		var result = false
		moviesGenre?.forEach {
			if(genreIds.contains(it)) {
				result = true
				return@forEach
			}
		}
		return result
	}
}