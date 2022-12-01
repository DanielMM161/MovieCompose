package com.dmm.moviecompose.domain.use_case.serie

import com.dmm.moviecompose.data.model.AudiovisualModel
import com.dmm.moviecompose.domain.repository.SerieRepository
import com.dmm.moviecompose.domain.util.MovieOrder

class GetSeries(
	val repository: SerieRepository
) {

	operator suspend fun invoke(
		movieOrder: MovieOrder = MovieOrder.Genre(listOf())
	): List<AudiovisualModel> {
		return repository.getPopularSeries(1).let { series ->
			when(movieOrder) {
				is MovieOrder.Genre -> {
					series.filter { series -> searchGenres(movieOrder.genreIds, series.genreİds) }
				}
				is MovieOrder.Popular -> {
					series
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