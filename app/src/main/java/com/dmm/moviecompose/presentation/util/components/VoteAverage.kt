package com.dmm.moviecompose.presentation.util.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VoteAverage(
	voteAverage: Double = 0.0
) {
	Row(
		horizontalArrangement = Arrangement.Center
	) {
		Icon(
			modifier = Modifier.size(20.dp),
			imageVector = Icons.Default.Star,
			tint = MaterialTheme.colors.primary,
			contentDescription = "Star"
		)
		Spacer(modifier = Modifier.width(6.dp))
		Text(
			text = voteAverage.toString(),
			style = MaterialTheme.typography.subtitle1,
		)
	}
}