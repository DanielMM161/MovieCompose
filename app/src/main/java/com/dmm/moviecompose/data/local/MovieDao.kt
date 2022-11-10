package com.dmm.moviecompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmm.moviecompose.data.model.detail.MovieDetail
import com.dmm.moviecompose.data.model.MoviesModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

	@Query("Select * FROM movies")
	fun getPopularMovies(): Flow<List<MoviesModel>>

	@Query("Select * FROM movie_detail Where id = :id")
	suspend fun getMovieById(id: Int): MovieDetail

	@Query("Select * FROM movies Where page = :page")
	fun getMoviesByPage(page: Int): Flow<List<MoviesModel>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertMovies(movieDetails: List<MoviesModel>)
}