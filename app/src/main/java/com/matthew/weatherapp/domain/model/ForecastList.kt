package com.matthew.weatherapp.domain.model

/**
 * Created by Matthew on 18/09/2017.
 */
class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {
    val size: Int get() = dailyForecast.size;
    operator fun get(position: Int): Forecast = dailyForecast[position]
}