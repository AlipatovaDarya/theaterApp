package com.example.theatreapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.theatreapp.R
import com.example.theatreapp.Utils
import com.example.theatreapp.models.Artist
import com.example.theatreapp.models.CarouselButtons
import com.example.theatreapp.models.Performance
import com.example.theatreapp.navigation.MainDestinations

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun MainScreen(navController: NavController) {
    val activePage = remember {
        mutableStateOf(CarouselButtons.PLAYBILL)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF0E0E11))
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.theatre_image),
                contentDescription = "null",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = "Театр им. Чехова",
                textAlign = TextAlign.Center,
                style = TextStyle(fontSize = 22.sp),
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Row {
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
            ButtonCarousel(activePage)
        }

        Spacer(modifier = Modifier.padding(vertical = 8.dp))


        when (activePage.value) {
            CarouselButtons.PLAYBILL -> {
                Row(
                    modifier = Modifier.align(Alignment.End),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Ближайшие спектакли",
                        style = TextStyle(fontSize = 14.sp, color = Color.White)
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.ic_filter),
                        contentDescription = "filter"
                    )
                    Spacer(modifier = Modifier.padding(horizontal = 8.dp))
                }
                PerformanceList(Utils.performanceList) { navController.navigate(MainDestinations.SELECT_SEAT_SCREEN) }
            }

            CarouselButtons.ARTISTS -> {
                ArtistsList(Utils.artistsList)
            }

            CarouselButtons.ABOUT_THEATER -> {

            }
        }
    }
}


@Composable
fun ButtonCarousel(activePage: MutableState<CarouselButtons>) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(20.dp) // Расстояние между кнопками
    ) {
        itemsIndexed(CarouselButtons.entries.toTypedArray()) { index, label ->
            Box(
                modifier = Modifier
                    .wrapContentWidth()
                    .height(60.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center // Центрируем содержимое по вертикали и горизонтали
            ) {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    onClick = {
                        selectedIndex = index
                        activePage.value = when (index) {
                            0 -> CarouselButtons.PLAYBILL
                            1 -> CarouselButtons.ARTISTS
                            else -> CarouselButtons.ABOUT_THEATER
                        }
                    },
                    modifier = Modifier
                        .wrapContentWidth()
                        .height(if (index == selectedIndex) 60.dp else 46.dp) // Изменение высоты при выборе
                        .clip(RoundedCornerShape(10.dp)),
                    contentPadding = PaddingValues(12.dp) //Отступ внутри кнопки

                ) {
                    Text(
                        text = label.title,
                        textAlign = TextAlign.Center,
                        fontSize = if (index == selectedIndex) 17.sp else 13.sp, // Изменение размера текста
                        color = Color(0xFF0E0E11),
                    )
                }
            }
        }
    }
}

@Composable
fun PerformanceList(list: List<Performance>, onClickBuy: ()-> Unit) {
    LazyColumn {
        itemsIndexed(list) { index, performance ->

            PerformanceItem(performance,onClickBuy)

            if (index < list.size - 1) {
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .background(Color.White),
                    thickness = 1.dp,
                    color = Color.White
                )
            }
        }
    }
}

@Composable
fun PerformanceItem(performance: Performance, onClickBuy: ()-> Unit) {
    Row(verticalAlignment = Alignment.Top) {
        Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = Utils.formatInstantToDate(performance.date),
                fontSize = 17.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(vertical = 2.dp))
            Text(
                text = Utils.formatInstantToTime(performance.date),
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(vertical = 2.dp))
            Text(
                text = performance.hall.name,
                fontSize = 14.sp,
                color = Color.White,
            )

        }

        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = performance.title,
                fontSize = 17.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = performance.author,
                fontSize = 12.sp,
                color = Color.White,
            )

            Text(
                text = performance.description,
                fontSize = 12.sp,
                color = Color.White,
            )
            Button(
                onClick = onClickBuy,
                content = { Text(text = "Купить билет") }
            )
        }

    }
}

@Composable
fun ArtistsList(artists: List<Artist>) {

    LazyColumn(modifier = Modifier.padding(horizontal = 14.dp)) {
        itemsIndexed(artists) { index, artist ->

            Column(modifier = Modifier.padding(12.dp)) {
                Text(
                    text = artist.name,
                    fontSize = 17.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = artist.description,
                    fontSize = 12.sp,
                    color = Color.White,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
            }

            if (index < artists.size - 1) {
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .background(Color.White),
                    thickness = 1.dp,
                    color = Color.White
                )
            }

        }
    }

}