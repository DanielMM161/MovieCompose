package com.dmm.moviecompose.domain.repository

import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.data.model.GenresModel
import com.dmm.moviecompose.data.model.Movie
import com.dmm.moviecompose.data.model.MoviesModel
import com.dmm.moviecompose.data.model.detail.MovieDetail
import kotlinx.coroutines.flow.Flow


interface MovieRepository {

	suspend fun getPopularMovies(page: Int): List<Movie>

	fun getMoviesByGenre(): Flow<List<MovieDetail>>

	suspend fun getMovieDetail(id: Int): MovieDetail

	suspend fun getMoviesGenre(): List<Genre>

	suspend fun insertMovies(movieDetailList: List<MovieDetail>)

	suspend fun insertMoviesGenre(moviesGenreList: List<Genre>)
}