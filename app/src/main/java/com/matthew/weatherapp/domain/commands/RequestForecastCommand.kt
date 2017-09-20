package com.matthew.weatherapp.domain.commands

import com.matthew.weatherapp.domain.datasource.ForecastProvider
import com.matthew.weatherapp.domain.model.ForecastList

class RequestForecastCommand(
        private val zipCode: Long,
        private val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)
}