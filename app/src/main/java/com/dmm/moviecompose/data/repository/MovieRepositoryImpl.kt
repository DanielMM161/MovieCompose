package com.dmm.moviecompose.data.repository

import com.dmm.moviecompose.data.local.MovieDao
import com.dmm.moviecompose.data.local.MovieGenreDao
import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.data.model.GenresModel
import com.dmm.moviecompose.data.model.Movie
import com.dmm.moviecompose.data.model.MoviesModel
import com.dmm.moviecompose.data.model.detail.MovieDetail
import com.dmm.moviecompose.data.remote.MovieApi
import com.dmm.moviecompose.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class MovieRepositoryImpl(
	private val movieApi: MovieApi,
	private val movieDao: MovieDao,
	private val genreDao: MovieGenreDao
): MovieRepository {

	override suspend fun getPopularMovies(page: Int): List<Movie> {
		var movies = movieDao.getPopularMovies(page)
		if (movies.isEmpty()) {
			movies = movieApi.getPopularMovies().movies
			movies.forEach { it.page = page }
			movieDao.insertMovies(movies)
		}
		return movies
	}

	override fun getMoviesByGenre(): Flow<List<MovieDetail>> {
		TODO("Not yet implemented")
	}

	override suspend fun getMovieDetail(id: Int): MovieDetail {
		var movideDetail = movieDao.getMovieDetail(id)
		if(movideDetail == null) {
			movideDetail = movieApi.getMovieDetail(id.toString())
			movieDao.insertMovieDetail(movideDetail)
		}
		return movideDetail
	}

	override suspend fun getMoviesGenre(): List<Genre> {
		var genres = genreDao.getMovieGenre()
		if(genres.isEmpty()) {
			genres = movieApi.getGenreMovies().genres
			genreDao.insertMoviesGenre(genres)
		}
		return genres
	}

	override suspend fun insertMovies(movieDetailList: List<MovieDetail>) {
		TODO("Not yet implemented")
	}

	override suspend fun insertMoviesGenre(moviesGenreList: List<Genre>) {
		TODO("Not yet implemented")
	}

}