package com.dmm.moviecompose.presentation.movie_detail.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmm.moviecompose.data.model.Cast
import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.presentation.util.components.VoteAverage
import com.dmm.moviecompose.ui.theme.Subtitle
import com.dmm.moviecompose.ui.theme.White
import kotlin.math.truncate

@Composable
fun DescriptionCard(
	title: String = "",
	overView: String = "",
	genreList: List<Genre>,
	releaseDate: String,
	voteAverage: Double,
	castList: List<Cast> = listOf()
) {
	val genres = genreList.map { it.name }.joinToString(", ")
	Log.e("cast --> ", "${castList.size}")
	Surface(
		color = White,
		modifier = Modifier
			.fillMaxSize()
			.padding(top = 300.dp)
			.verticalScroll(rememberScrollState())
	) {
		Column(
			modifier = Modifier
				.padding(26.dp),
			verticalArrangement = Arrangement.Top,
			horizontalAlignment = Alignment.Start,
		) {
			//Title
			Text(
				text = title,
				style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold)
			)
			Spacer(modifier = Modifier.size(2.dp))

			//Genres
			Text(
				text = genres,
				color = Subtitle
			)
			Spacer(modifier = Modifier.size(4.dp))

			//Release Date
			Text(
				text = "Release: ${releaseDate}",
				color = Subtitle
			)
			Spacer(modifier = Modifier.size(8.dp))

			//Vote Average
			VoteAverage(truncate(voteAverage))
			Spacer(modifier = Modifier.size(26.dp))

			//Overview
			Text(
				text = "Overview",
				style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
			)
			Spacer(modifier = Modifier.size(14.dp))
			Text(
				text = overView,
				fontSize = 17.sp
			)
			Spacer(modifier = Modifier.size(26.dp))

			if(castList.isNotEmpty()) {
				Text(
					text = "Cast",
					style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold)
				)
				Spacer(modifier = Modifier.size(14.dp))
				LazyRow(modifier = Modifier.fillMaxWidth()) {
					items(castList) {
						CastSection(
							name = it.name,
							profilePath = it.profilePath ?: ""
						) {

						}
					}
				}
			}
		}
	}
}