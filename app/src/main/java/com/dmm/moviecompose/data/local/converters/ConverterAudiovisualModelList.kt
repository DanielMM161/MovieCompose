package com.dmm.moviecompose.data.local.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.dmm.moviecompose.data.model.AudiovisualModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ConverterAudiovisualModelList@Inject constructor(
	private val moshi: Moshi
){

	@TypeConverter
	fun fromString(value: String): List<AudiovisualModel>? {
		val listType = Types.newParameterizedType(List::class.java, AudiovisualModel::class.java)
		val adapter: JsonAdapter<List<AudiovisualModel>> = moshi.adapter(listType)
		return adapter.fromJson(value)
	}

	@TypeConverter
	fun fromListString(list: List<AudiovisualModel>?): String {
		val listType = Types.newParameterizedType(List::class.java, AudiovisualModel::class.java)
		val adapter: JsonAdapter<List<AudiovisualModel>> = moshi.adapter(listType)
		return adapter.toJson(list)
	}
}