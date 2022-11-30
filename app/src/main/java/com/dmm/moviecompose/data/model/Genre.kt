package com.dmm.moviecompose.data.model

import com.squareup.moshi.Json
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity( tableName = "genre")
@JsonClass(generateAdapter = true)
data class Genre(
	@PrimaryKey
	@ColumnInfo(name = "id")
	@field:Json(name = "id")
	val genre_id: Int = 0,
	@ColumnInfo(name = "name")
	@field:Json(name = "name")
	val name: String = "",
	@ColumnInfo(name = "is_selected")
	val isSelected: Boolean = false,
	@ColumnInfo(name = "genre_type")
	val genreType: String = ""
)
