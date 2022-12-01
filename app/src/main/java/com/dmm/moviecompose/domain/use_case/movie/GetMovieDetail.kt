package com.dmm.moviecompose.domain.use_case.movie

import com.dmm.moviecompose.data.model.detail.MovieDetail
import com.dmm.moviecompose.domain.repository.MovieRepository

class GetMovieDetail(
	val repository: MovieRepository
) {

	operator suspend fun invoke(id: Int): MovieDetail {
		return repository.getMovieDetail(id)
	}
}