package com.dmm.moviecompose.data.remote

import com.dmm.moviecompose.data.model.GenreListDto
import com.dmm.moviecompose.data.model.MovieDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

	companion object {
		const val SERIES_GENRE = "3/genre/tv/list"
		const val MOVIE_GENRE = "3/genre/movie/list"
		const val POPULAR_MOVIES = "3/movie/popular"
		const val SERIES_POPULAR = "3/tv/popular"
	}

	@GET(POPULAR_MOVIES)
	suspend fun getPopularMovies(
		@Query("api_key") apiKey: String
	): MovieDto

	@GET(SERIES_POPULAR)
	suspend fun getPopularTV(
		@Query("api_key") apiKey: String
	): MovieDto

	@GET(MOVIE_GENRE)
	suspend fun getGenreMovies(
		@Query("api_key") apiKey: String,
		@Query("language") language: String = "en-US"
	): GenreListDto

	@GET(SERIES_GENRE)
	suspend fun getGenreTV(
		@Query("api_key") apiKey: String,
		@Query("language") language: String = "en-US"
	): GenreListDto
}