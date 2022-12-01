package com.dmm.moviecompose.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.moviecompose.data.model.Genre
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ConverterGenreDto @Inject constructor(
	private val moshi: Moshi
){

	@TypeConverter
	fun fromString(value: String): List<Genre>? {
		val listType = Types.newParameterizedType(List::class.java, Genre::class.java)
		val adapter: JsonAdapter<List<Genre>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromListString(list: List<Genre>?): String {
		val listType = Types.newParameterizedType(List::class.java, Genre::class.java)
		val adapter: JsonAdapter<List<Genre>> = moshi.adapter(listType)
		return adapter.toJson(list)
	}
}