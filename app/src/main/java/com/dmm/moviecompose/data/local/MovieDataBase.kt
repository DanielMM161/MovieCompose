package com.dmm.moviecompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dmm.moviecompose.data.local.converters.ConverterMovieDetailGenreList
import com.dmm.moviecompose.data.local.converters.ConverterMovieGenreList
import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.data.model.Movie
import com.dmm.moviecompose.data.model.detail.MovieDetail

@TypeConverters( value = [ConverterMovieGenreList::class, ConverterMovieDetailGenreList::class])
@Database(
	entities = [Genre::class, Movie::class, MovieDetail::class],
	version = 1,
	exportSchema = false
)
abstract class MovieDataBase() : RoomDatabase() {

	abstract val movieDao: MovieDao

	abstract val movieGenreDao: MovieGenreDao

	companion object {
		val DATABASE_NAME = "movie_db"
	}

}
