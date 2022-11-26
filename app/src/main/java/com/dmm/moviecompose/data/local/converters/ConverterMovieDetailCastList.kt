package com.dmm.moviecompose.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.moviecompose.data.model.Cast
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ConverterMovieDetailCastList @Inject constructor(
	private val moshi: Moshi
){
	@TypeConverter
	fun fromString(value: String): List<Cast>? {
		val listType = Types.newParameterizedType(List::class.java, Cast::class.java)
		val adapter: JsonAdapter<List<Cast>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromListCast(list: List<Cast>?): String {
		val listType = Types.newParameterizedType(List::class.java, Cast::class.java)
		val adapter: JsonAdapter<List<Cast>> = moshi.adapter(listType)
		return adapter.toJson(list)
	}
}