package com.dmm.moviecompose.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dmm.moviecompose.data.local.converters.ConverterAudiovisualModelList
import com.dmm.moviecompose.data.local.converters.ConverterMovieDetailCastList
import com.dmm.moviecompose.data.local.converters.ConverterMovieDetailGenreList
import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.data.model.MoviesModel
import com.dmm.moviecompose.data.model.SeriesModel
import com.dmm.moviecompose.data.model.detail.MovieDetail
import com.dmm.moviecompose.data.model.detail.SerieDetail

@TypeConverters(
	value = [
		ConverterMovieDetailGenreList::class,
		ConverterMovieDetailCastList::class,
		ConverterAudiovisualModelList::class
	]
)
@Database(
	entities = [
		Genre::class,
		MovieDetail::class,
		SerieDetail::class,
		MoviesModel::class,
		SeriesModel::class,
	],
	version = 1,
	exportSchema = false
)
abstract class AudiovisualDataBase() : RoomDatabase() {

	abstract val movieDao: MovieDao

	abstract val genreDao: GenreDao

	abstract val serieDao: SerieDao

	companion object {
		val DATABASE_NAME = "movie_db"
	}

}
