package com.matthew.weatherapp.domain.commands

import com.matthew.weatherapp.domain.datasource.ForecastProvider
import com.matthew.weatherapp.domain.model.Forecast

class RequestDayForecastCommand(
        val id: Long,
        private val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<Forecast> {

    override fun execute() = forecastProvider.requestForecast(id)
}