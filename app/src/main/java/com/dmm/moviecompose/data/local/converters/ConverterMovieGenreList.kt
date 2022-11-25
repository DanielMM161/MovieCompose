package com.dmm.moviecompose.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ConverterMovieGenreList @Inject constructor(
	private val moshi: Moshi
){

	@TypeConverter
	fun fromString(value: String): List<Int>? {
		val listType = Types.newParameterizedType(List::class.java, Integer::class.java)
		val adapter: JsonAdapter<List<Int>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromListString(list: List<Int>?): String {
		val listType = Types.newParameterizedType(List::class.java, Integer::class.java)
		val adapter: JsonAdapter<List<Int>> = moshi.adapter(listType)
		return adapter.toJson(list)
	}
}