package com.dmm.moviecompose.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Cast(
	@field:Json(name = "id")
	val id: Int = 0,
	@field:Json(name = "known_for_department")
	val department: String = "",
	@field:Json(name = "name")
	val name: String = "",
	@field:Json(name = "original_name")
	val original_name: String = "",
	@field:Json(name = "popularity")
	val popularity: Double = 0.0,
	@field:Json(name = "profile_path")
	val profilePath: String? = null,
	@field:Json(name = "cast_id")
	val castId: String = "",
	@field:Json(name = "character")
	val character: String = "",
	@field:Json(name = "credit_id")
	val creditId: String = "",
)
