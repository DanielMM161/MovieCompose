package com.dmm.moviecompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmm.moviecompose.data.model.MovieGenre

@Dao
interface MovieGenreDao {

	@Query("SELECT * FROM genre")
	suspend fun getMovieGenre(): List<MovieGenre>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertMoviesGenre(moviesGenreList: List<MovieGenre>)

}