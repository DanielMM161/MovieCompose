package com.dmm.moviecompose.data.repository

import com.dmm.moviecompose.data.local.MovieDao
import com.dmm.moviecompose.data.local.GenreDao
import com.dmm.moviecompose.data.model.*
import com.dmm.moviecompose.data.model.detail.MovieDetail
import com.dmm.moviecompose.data.remote.AudiovisualApi
import com.dmm.moviecompose.domain.repository.MovieRepository
import com.dmm.moviecompose.utils.Constants.MOVIE_TYPE

class MovieRepositoryImpl(
	private val audiovisualApi: AudiovisualApi,
	private val movieDao: MovieDao,
	private val genreDao: GenreDao
): MovieRepository {

	override suspend fun getPopularMovies(page: Int): List<AudiovisualModel> {
		var moviesModel = movieDao.getPopularMovies(page)
		if (moviesModel == null) {
			moviesModel = audiovisualApi.getPopularMovies()
			movieDao.insertMovies(moviesModel)
		}
		return moviesModel.movies
	}

	override suspend fun getMovieDetail(movieId: Int): MovieDetail {
		var movideDetail = movieDao.getMovieDetail(movieId)
		if(movideDetail == null) {
			movideDetail = audiovisualApi
				.getMovieDetail(movieId.toString())
				.copy(cast = getMovieCast(movieId))
			movieDao.insertMovieDetail(movideDetail)
		}
		return movideDetail
	}

	private suspend fun getMovieCast(movieId: Int): List<Cast> {
		val castList = audiovisualApi.getMovieCredits(movieId.toString()).cast
		if(castList.isNotEmpty()) {
			return castList
		}
		return listOf()
	}

	override suspend fun getMoviesGenre(): List<Genre> {
		var genres = genreDao.getMovieGenre()
		if(genres.isEmpty()) {
			genres = audiovisualApi.getGenreMovies().genres
			genres.map { genre -> genre.copy(genreType = MOVIE_TYPE)}
			genreDao.insertGenres(genres)
		}
		return genres
	}
}