package com.dmm.moviecompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmm.moviecompose.data.model.detail.MovieDetail
import com.dmm.moviecompose.data.model.SeriesModel
import com.dmm.moviecompose.data.model.detail.SerieDetail

@Dao
interface SerieDao {

	@Query("Select * FROM series Where page = :page")
	suspend fun getPopularSeries(page: Int): SeriesModel?

	@Query("Select * FROM serie_detail Where id = :id")
	suspend fun getSerieDetail(id: Int): SerieDetail?

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertSerieDetail(serieDetail: SerieDetail)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertSeriesModel(serieModel: SeriesModel)
}