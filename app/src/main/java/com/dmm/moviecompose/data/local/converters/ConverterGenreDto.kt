package com.dmm.moviecompose.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.moviecompose.data.model.MovieGenre
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ConverterGenreDto @Inject constructor(
	private val moshi: Moshi
){

	@TypeConverter
	fun fromString(value: String): List<MovieGenre>? {
		val listType = Types.newParameterizedType(List::class.java, MovieGenre::class.java)
		val adapter: JsonAdapter<List<MovieGenre>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromListString(list: List<MovieGenre>?): String {
		val listType = Types.newParameterizedType(List::class.java, MovieGenre::class.java)
		val adapter: JsonAdapter<List<MovieGenre>> = moshi.adapter(listType)
		return adapter.toJson(list)
	}
}