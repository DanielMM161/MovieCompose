package com.dmm.moviecompose.domain.repository

import com.dmm.moviecompose.data.model.MovieGenre
import com.dmm.moviecompose.data.model.MovieGenresModel
import com.dmm.moviecompose.data.model.MoviesModel
import com.dmm.moviecompose.data.model.detail.MovieDetail
import kotlinx.coroutines.flow.Flow


interface MovieRepository {

	fun getPopularMovies(): Flow<MoviesModel>

	fun getMoviesByGenre(): Flow<List<MovieDetail>>

	suspend fun getMovieDetail(id: Int): MovieDetail

	suspend fun getMoviesGenre(): MovieGenresModel

	suspend fun insertMovies(movieDetailList: List<MovieDetail>)

	suspend fun insertMoviesGenre(moviesGenreList: List<MovieGenre>)
}