package com.dmm.moviecompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dmm.moviecompose.data.local.converters.ConvertGenreDto
import com.dmm.moviecompose.data.model.GenreDto
import com.dmm.moviecompose.data.model.MovieDto

@Database(
	entities =[MovieDto::class, GenreDto::class],
	version = 1
)
@TypeConverters(value = [ConvertGenreDto::class])
abstract class MovieDataBase() : RoomDatabase() {

	abstract val movieDao: MovieDao

	companion object {
		val DATABASE_NAME = "movie_db"
	}

}
