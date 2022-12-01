package com.dmm.moviecompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.utils.Constants.MOVIE_TYPE
import com.dmm.moviecompose.utils.Constants.SERIE_TYPE

@Dao
interface GenreDao {

	@Query("SELECT * FROM genre WHERE genre_type = :genreType ")
	suspend fun getMovieGenre(genreType: String = MOVIE_TYPE): List<Genre>


	@Query("SELECT * FROM genre WHERE genre_type = :genreType ")
	suspend fun getSerieGenre(genreType: String = SERIE_TYPE): List<Genre>

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertGenres(moviesGenreList: List<Genre>)

}