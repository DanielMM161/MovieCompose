package com.dmm.moviecompose.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CastModel(
	@field:Json(name = "id")
	val id: Int = 0,
	@field:Json(name = "cast")
	val cast: List<Cast> = listOf(),
)
