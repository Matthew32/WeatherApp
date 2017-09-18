package com.matthew.weatherapp.data

import java.util.*

/**
 * Created by Matthew on 18/09/2017.
 */
data class Forecast(val dt: Long, val temp: ResponseClasses.Temperature, val pressure: Float, val humidity: Int,
                    val weather: List<ResponseClasses.Weather>, val speed: Float,
                    val deg: Int, val clouds: Int, val rain: Float);

