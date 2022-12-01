package com.dmm.moviecompose.presentation.movies.component


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dmm.moviecompose.data.model.Genre
import com.dmm.moviecompose.ui.theme.Black
import com.dmm.moviecompose.ui.theme.White

@Composable
fun ChipSection(
	genreList: List<Genre>,
	onClick: (Int) -> Unit
) {
	LazyRow {
		itemsIndexed(genreList) { index, genre ->
			Box(
				contentAlignment = Alignment.Center,
				modifier = Modifier
					.padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
					.clip(RoundedCornerShape(10.dp))
					.clickable {
						onClick(genre.genre_id)
					}
					.background(
						if (genre.isSelected) MaterialTheme.colors.primary
						else MaterialTheme.colors.secondary
					)
					.padding(10.dp)
			) {
				Text(text = genre.name, color = if(genre.isSelected) White else Black)
			}
		}
	}

}

@Composable
fun ChipItem(
	genre: Genre,
	isSelected: Boolean = false,
	genreListener: (Int) -> Unit
) {
	Box(
		contentAlignment = Alignment.Center,
		modifier = Modifier
			.padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
			.clip(RoundedCornerShape(10.dp))
			.clickable {
				genreListener(genre.genre_id)
			}
			.background(
				if (isSelected) MaterialTheme.colors.primary
				else MaterialTheme.colors.secondary
			)
			.padding(15.dp)
	) {
		Text(text = genre.name, color = if(isSelected) White else Black)
	}
}

