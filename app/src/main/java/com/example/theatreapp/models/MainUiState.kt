package com.example.theatreapp.models

data class MainUiState(
    val activeButton: CarouselButtons
)

enum class CarouselButtons(val title: String){
    PLAYBILL("Афиша"),
    ARTISTS("Артисты"),
    ABOUT_THEATER("О театре")
}