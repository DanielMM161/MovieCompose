package com.dmm.moviecompose.presentation.movies.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dmm.moviecompose.presentation.util.components.VoteAverage
import com.dmm.moviecompose.ui.theme.MoviewComposeTheme
import com.dmm.moviecompose.ui.theme.Subtitle
import com.dmm.moviecompose.utils.Constants.BASE_IMAGE_URL

@Composable
fun MovieItem(
	title: String = "Prueba",
	posterPath: String = "",
	overView: String = "",
	voteAverage: Double,
	modifier: Modifier = Modifier
) {
	val url = BASE_IMAGE_URL + posterPath
	Card(
		elevation = 4.dp,
		shape = RoundedCornerShape(10.dp),
		modifier = modifier.fillMaxWidth().height(140.dp)
	) {
		Row() {
			AsyncImage(
				model = url,
				contentDescription = "",
				alignment = Alignment.CenterStart,
				contentScale = ContentScale.Fit
			)
			Column(
				modifier = Modifier.padding(16.dp),
				verticalArrangement = Arrangement.spacedBy(10.dp)
			) {
				Text(
					text = title,
					maxLines = 1,
					style = MaterialTheme.typography.h6,
					color = MaterialTheme.colors.onSurface,
					overflow = TextOverflow.Ellipsis
				)
				Text(
					text = overView,
					maxLines = 2,
					style = MaterialTheme.typography.subtitle1,
					color = Subtitle,
					overflow = TextOverflow.Ellipsis
				)
				VoteAverage(voteAverage)
			}
		}
	}
}