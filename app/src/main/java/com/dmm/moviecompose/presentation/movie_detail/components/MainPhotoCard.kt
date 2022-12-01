package com.dmm.moviecompose.presentation.movie_detail.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter.State.Empty.painter
import coil.compose.rememberAsyncImagePainter
import com.dmm.moviecompose.R
import com.dmm.moviecompose.ui.theme.White
import com.dmm.moviecompose.utils.Constants.BASE_IMAGE_URL

@Composable
fun MainPhotoCard(
	backdropPath: String = "",
	clickArrowBack: () -> Unit
) {
	val url = BASE_IMAGE_URL + backdropPath
	Surface(
		color = Color.Transparent,
		modifier = Modifier
			.height(300.dp)
			.fillMaxWidth(),
		shape = RoundedCornerShape(60.dp).copy(topStart = ZeroCornerSize, topEnd = ZeroCornerSize)
	) {
		Box() {
			AsyncImage(
				model = url,
				modifier = Modifier.fillMaxSize(),
				contentScale = ContentScale.Crop,
				contentDescription = "",
			)
			Icon(
				imageVector = Icons.Default.ArrowBack,
				contentDescription = "",
				tint = White,
				modifier = Modifier
					.align(Alignment.TopStart)
					.padding(18.dp)
					.clickable {
						clickArrowBack()
					}
			)
		}
	}
}
