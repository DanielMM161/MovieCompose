package com.dmm.moviecompose.presentation.movie_detail.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dmm.moviecompose.data.model.Cast
import com.dmm.moviecompose.utils.Constants
import com.dmm.moviecompose.utils.Constants.BASE_IMAGE_URL

@Composable
fun CastSection(
	profilePath: String = "",
	name: String = "",
	onClick: () -> Unit
) {
	val url = BASE_IMAGE_URL + profilePath
	val actorName = name.split(" ")
	Card(
		modifier = Modifier
			.fillMaxWidth()
			.padding(end = 15.dp)
			.clickable {
				onClick()
			},
		shape = RoundedCornerShape(10.dp),
		elevation = 10.dp
	) {
		Row(
			modifier = Modifier.padding(10.dp),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			AsyncImage(
				model = url,
				modifier = Modifier
					.size(70.dp)
					.clip(RoundedCornerShape(percent = 10)),
				contentScale = ContentScale.Crop,
				contentDescription = "",
			)
			Spacer(modifier = Modifier.size(8.dp))
			Column() {
				actorName.take(2).forEach {
					Text(
						text = it,
						fontWeight = FontWeight.Medium
					)
				}
			}
		}
	}
}