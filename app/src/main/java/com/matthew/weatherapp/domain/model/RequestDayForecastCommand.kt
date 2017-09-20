package com.matthew.weatherapp.domain.model

import com.matthew.weatherapp.domain.datasource.ForecastProvider

/**
 * Created by Matthew on 20/09/2017.
 */
class RequestDayForecastCommand(val id: Long, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<Forecast> {
    override fun execute() = forecastProvider.requestForecast(id);


}