package com.dmm.moviecompose.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "movies")
@JsonClass(generateAdapter = true)
data class MoviesModel(
	@PrimaryKey()
	@ColumnInfo(name = "page")
	@field:Json(name = "page")
	val page: Int = 1,
	@ColumnInfo(name = "results")
	@field:Json(name = "results")
	val movies: List<AudiovisualModel> = listOf(),
	@field:Json(name = "total_pages")
	val totalPages: Int = 0,
	@field:Json(name = "total_results")
	val totalResults: Int = 0
)
