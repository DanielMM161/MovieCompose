package com.dmm.moviecompose.data.remote

import com.dmm.moviecompose.data.model.GenresModel
import com.dmm.moviecompose.data.model.MoviesModel
import com.dmm.moviecompose.data.model.detail.MovieDetail
import com.dmm.moviecompose.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

	companion object {
		const val SERIES_GENRE = "3/genre/tv/list"
		const val GENRE_MOVIES = "3/genre/movie/list"
		const val POPULAR_MOVIES = "3/movie/popular"
		const val MOVIE_DETAIL = "3/movie/{movieId}"
		const val CREDITS = "3/movie/{movieId}/credits"
		const val SERIES_POPULAR = "3/tv/popular"
	}

	@GET(POPULAR_MOVIES)
	suspend fun getPopularMovies(
		@Query("api_key") apiKey: String = API_KEY,
		@Query("language") language: String = "en-US",
		@Query("page") page: Int = 1
	): MoviesModel

	@GET(MOVIE_DETAIL)
	suspend fun getMovieDetail(
		@Path("movieId") movieId: String,
		@Query("api_key") apiKey: String = API_KEY,
		@Query("language") language: String = "en-US"
	): MovieDetail

	@GET(GENRE_MOVIES)
	suspend fun getGenreMovies(
		@Query("api_key") apiKey: String = API_KEY,
		@Query("language") language: String = "en-US"
	): GenresModel

//	@GET(SERIES_POPULAR)
//	suspend fun getPopularTV(
//		@Query("api_key") apiKey: String
//	): MovieDetail

	@GET(SERIES_GENRE)
	suspend fun getGenreTV(
		@Query("api_key") apiKey: String = API_KEY,
		@Query("language") language: String = "en-US"
	): GenresModel
}