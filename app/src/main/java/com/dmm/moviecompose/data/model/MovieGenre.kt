package com.dmm.moviecompose.data.model

import com.squareup.moshi.Json
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity( tableName = "genre")
data class MovieGenre(
	@PrimaryKey
	@ColumnInfo(name = "id")
	@field:Json(name = "id")
	val genre_id: Int?,
	@ColumnInfo(name = "name")
	@field:Json(name = "name")
	val name: String?
)
