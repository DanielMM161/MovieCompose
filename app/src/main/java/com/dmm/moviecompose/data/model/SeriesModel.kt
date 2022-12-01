package com.dmm.moviecompose.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "series")
@JsonClass(generateAdapter = true)
data class SeriesModel(
	@PrimaryKey()
	@field:Json(name = "page")
	val page: Int = 1,
	@field:Json(name = "results")
	val series: List<AudiovisualModel> = listOf(),
	@field:Json(name = "total_pages")
	val totalPages: Int = 0,
	@field:Json(name = "total_results")
	val totalResults: Int = 0
)
