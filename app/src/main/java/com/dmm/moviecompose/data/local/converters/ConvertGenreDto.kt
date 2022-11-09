package com.dmm.moviecompose.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.moviecompose.data.model.GenreDto
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ConvertGenreDto @Inject constructor(
	private val moshi: Moshi
){

	@TypeConverter
	fun fromString(value: String): List<GenreDto>? {
		val listType = Types.newParameterizedType(List::class.java, GenreDto::class.java)
		val adapter: JsonAdapter<List<GenreDto>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromListString(list: List<GenreDto>?): String {
		val listType = Types.newParameterizedType(List::class.java, GenreDto::class.java)
		val adapter: JsonAdapter<List<GenreDto>> = moshi.adapter(listType)
		return adapter.toJson(list)
	}
}