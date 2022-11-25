package com.dmm.moviecompose.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmm.moviecompose.data.model.Movie
import com.dmm.moviecompose.data.model.detail.MovieDetail
import com.dmm.moviecompose.data.model.MoviesModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

	@Query("Select * FROM movie Where page = :page")
	suspend fun getPopularMovies(page: Int): List<Movie>

	@Query("Select * FROM movie_detail Where id = :id")
	suspend fun getMovieDetail(id: Int): MovieDetail

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertMovieDetail(movieDetail: MovieDetail)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertMovies(movieList: List<Movie>)
}