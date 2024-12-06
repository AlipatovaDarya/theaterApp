package com.example.theatreapp.models

import java.time.LocalDateTime

data class Performance(
    val date: LocalDateTime,
    val title: String,
    val author: String,
    val description: String,
    val hall: Hall
)

data class Hall(
    val name: String,
    val capacity: Int
)
