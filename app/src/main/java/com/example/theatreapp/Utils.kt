package com.example.theatreapp

import com.example.theatreapp.models.Artist
import com.example.theatreapp.models.Hall
import com.example.theatreapp.models.Performance
import com.example.theatreapp.view.Seat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Utils {

    val artistsList =
        mutableListOf(
            Artist(
                name = "Александр Александрович Литягин",
                description = "Художественный руководитель Воронежского государственного театра оперы и балета, Заслуженный артист ВО, лауреат международного конкурса.",
            ),
            Artist(
                name = "Юрий Петрович Анисичкин",
                description = "Главный дирижёр Воронежского театра оперы и балета, Заслуженный деятель искусств РФ, профессор.",
            ),
            Artist(
                name = "Ольга Владимировна Щербань",
                description = "Главный хормейстер Воронежского государственного театра оперы и балета, Заслуженный деятель искусств ВО",
            ),

            )

    val performanceList =
        mutableListOf(
            Performance(
                date = LocalDateTime.of(2024, 12, 5, 18, 0),
                title = "Ночь перед Рождеством",
                author = "Николай Римский-Корсаков",
                description = "быль-колядка в 2-х действиях",
                hall = Hall("Малый зал", 50),
            ),
            Performance(
                date = LocalDateTime.of(2024, 12, 8, 19, 0),
                title = "Дюймовочка",
                author = "Пётр Чайковский",
                description = "балет-сказка в одном действии",
                hall = Hall("Большой зал", 70),
            ),
            Performance(
                date = LocalDateTime.of(2024, 12, 8, 19, 0),
                title = "Щелкунчик",
                author = "Пётр Чайковский",
                description = "балет в 2-х действиях",
                hall = Hall("Главный зал", 100),
            ),

            )

    val seats = listOf(
        Seat(1, 1, 1500, true),
        Seat(1, 2, 1200, true),
        Seat(1, 3, 1500, false),
        Seat(1, 4, 1800, true),
        Seat(2, 1, 1000, true),
        Seat(2, 2, 2000, true),
        Seat(2, 3, 1000, true),
        Seat(2, 4, 1000, true),
        Seat(3, 1, 2000, true),
        Seat(2, 2, 1000, true),
        Seat(2, 3, 1000, true),
        Seat(2, 4, 2000, true),
        Seat(4, 1, 1000, false),
        Seat(2, 2, 1000, true),
        Seat(2, 3, 1000, true),
        Seat(2, 4, 1000, true),

        )

    fun formatInstantToDate(localDateTime: LocalDateTime): String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return localDateTime.format(formatter)
    }

    fun formatInstantToTime(localDateTime: LocalDateTime): String {
        val formatter = DateTimeFormatter.ofPattern("HH:mm")
        return localDateTime.format(formatter)
    }

}