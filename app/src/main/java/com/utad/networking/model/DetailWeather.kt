package com.utad.networking.model

data class DetailWeather(
    val weather_state_name: String,
    val applicable_date: String,
    val min_temp: Double,
    val max_temp: Double,
    val the_temp: Double,
    val humidity: Int
)
