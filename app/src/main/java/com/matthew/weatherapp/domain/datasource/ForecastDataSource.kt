package com.matthew.weatherapp.domain.datasource

import com.matthew.weatherapp.domain.model.Forecast
import com.matthew.weatherapp.domain.model.ForecastList

interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?

}