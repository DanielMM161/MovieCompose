package com.dmm.moviecompose.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.moviecompose.data.model.Movie
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ConverterMovieList @Inject constructor(
	private val moshi: Moshi
){

	@TypeConverter
	fun fromString(value: String): List<Movie>? {
		val listType = Types.newParameterizedType(List::class.java, Movie::class.java)
		val adapter: JsonAdapter<List<Movie>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromListString(list: List<Movie>?): String {
		val listType = Types.newParameterizedType(List::class.java, Movie::class.java)
		val adapter: JsonAdapter<List<Movie>> = moshi.adapter(listType)
		return adapter.toJson(list)
	}
}