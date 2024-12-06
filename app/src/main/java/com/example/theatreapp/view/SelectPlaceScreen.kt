package com.example.theatreapp.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.theatreapp.Utils


data class Seat(val row: Int, val seat: Int, val price: Int, val isAvailable: Boolean)

@SuppressLint("MutableCollectionMutableState")
@Composable
fun SeatSelectionScreen(navController: NavController) {
    val seats by remember { mutableStateOf(Utils.seats)    }
    val selectedSeats = remember { mutableStateOf(mutableSetOf<Seat>()) }
    Log.d("Seats", "size = ${ selectedSeats.value.size };  selectedSeats: $selectedSeats.value")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(seats) { seat ->
                SeatItem(seat, selectedSeats,
                    /*onSeatClick = {
                        if(seat.isAvailable) {
                            if (selectedSeats.value.contains(seat)) {
                                Log.d("Seats", "IN IF: selectedSeats.value.contains(seat), seat = $seat")
                                Log.d("Seats", "1 size = ${ selectedSeats.value.size };  selectedSeats: $selectedSeats.value")
                                selectedSeats.value.remove(seat)
                            } else {
                                selectedSeats.value.add(seat)
                                Log.d("Seats", "IN IF NOT contains: selectedSeats.value.contains(seat), seat = $seat")
                                Log.d("Seats", "1 size = ${ selectedSeats.value.size };  selectedSeats: $selectedSeats.value")
                            }
                        }
                    }*/
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("Выбрано мест: ${selectedSeats.value.size}", fontSize = 18.sp, textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun SeatItem(seat: Seat, selectedSeats:  MutableState<MutableSet<Seat>>,
             //onSeatClick: (Seat) -> Unit
) {
    Log.e("Seats", "size = ${ selectedSeats.value.size };  selectedSeats: $selectedSeats.value")
    val color = when {
        !seat.isAvailable -> Color.Gray
        seat.price < 1000 -> Color.Green //Пример ценовой категории
        seat.price < 2000 -> Color.Yellow //Пример ценовой категории
        else -> Color.Red //Пример ценовой категории
    }
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(color)
            .clickable(enabled = seat.isAvailable) {
                //onSeatClick(seat)
                if (seat.isAvailable) {
                    if (selectedSeats.value.contains(seat)) {
                        Log.d("Seats", "IN IF: selectedSeats.value.contains(seat), seat = $seat")
                        Log.d(
                            "Seats",
                            "1 size = ${selectedSeats.value.size};  selectedSeats: $selectedSeats.value"
                        )
                        selectedSeats.value.remove(seat)
                    } else {
                        selectedSeats.value.add(seat)
                        Log.d(
                            "Seats",
                            "IN IF NOT contains: selectedSeats.value.contains(seat), seat = $seat"
                        )
                        Log.d(
                            "Seats",
                            "1 size = ${selectedSeats.value.size};  selectedSeats: $selectedSeats.value"
                        )
                    }
                }
            },
        contentAlignment = Alignment.Center
    ) {
        if (selectedSeats.value.contains(seat)) {
            Text("✅", color = Color.Black, fontSize = 16.sp) //Индикатор выбранного места
        } else {
            Text("${seat.row}-${seat.seat}", fontSize = 12.sp, color = Color.White)
        }
    }
}