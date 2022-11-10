package com.dmm.moviecompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dmm.moviecompose.data.local.converters.ConverterGenreDto
import com.dmm.moviecompose.data.local.converters.ConverterMovieList
import com.dmm.moviecompose.data.model.MovieGenre
import com.dmm.moviecompose.data.model.MoviesModel
import com.dmm.moviecompose.data.model.detail.MovieDetail

@Database(
	entities =[MoviesModel::class, MovieGenre::class, MovieDetail::class],
	version = 1
)
@TypeConverters(value = [ConverterGenreDto::class, ConverterMovieList::class])
abstract class MovieDataBase() : RoomDatabase() {

	abstract val movieDao: MovieDao

	abstract val movieGenreDao: MovieGenreDao

	companion object {
		val DATABASE_NAME = "movie_db"
	}

}
