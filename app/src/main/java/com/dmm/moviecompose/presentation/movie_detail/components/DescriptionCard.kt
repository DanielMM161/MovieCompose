package com.dmm.moviecompose.presentation.movie_detail.components

import androidx.compose.foundation.layout.*
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
	voteAverage: Double
) {
	var genres = genreList.map { it.name }.joinToString(", ")
	Surface(
		color = White,
		modifier = Modifier
			.fillMaxSize()
			.padding(top = 300.dp)
	) {
		Column(
			modifier = Modifier
				.verticalScroll(rememberScrollState())
				.padding(26.dp),
			verticalArrangement = Arrangement.Top,
			horizontalAlignment = Alignment.Start,
		) {
			//Title
			Text(
				text = title,
				style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.Bold)
			)
			Spacer(modifier = Modifier.size(8.dp))

			//Genres
			Text(
				text = genres,
				color = Subtitle
			)
			Spacer(modifier = Modifier.size(8.dp))

			//Release Date
			Text(
				text = "Release: ${releaseDate}",
				color = Subtitle
			)

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
		}
	}
}