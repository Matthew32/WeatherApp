package com.matthew.weatherapp.domain.datasource

import com.matthew.weatherapp.domain.model.ForecastList

/**
 * Created by Matthew on 19/09/2017.
 */

interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?
}