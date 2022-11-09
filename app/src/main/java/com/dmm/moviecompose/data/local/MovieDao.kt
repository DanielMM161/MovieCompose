package com.dmm.moviecompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmm.moviecompose.data.model.MovieDto
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

	@Query("Select * FROM movie")
	fun getMovies(): Flow<List<MovieDto>>

	@Query("Select * FROM movie Where genres = :genre")
	fun getMoviesByGenre(genre: Int): Flow<List<MovieDto>>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertMovies(movies: List<MovieDto>)
}