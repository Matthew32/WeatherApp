package com.matthew.weatherapp.domain.datasource

import com.matthew.weatherapp.data.Server.ForecastServer
import com.matthew.weatherapp.data.db.ForecastDb
import com.matthew.weatherapp.domain.model.ForecastDataSource
import com.matthew.weatherapp.domain.model.ForecastList
import com.matthew.weatherapp.extensions.firstResult

/**
 * Created by Matthew on 19/09/2017.
 */
class ForecastProvider(val sources: List<ForecastDataSource> = SOURCES as List<ForecastDataSource>) {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCES = listOf(ForecastDb(), ForecastServer())
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList
            = sources.firstResult { requestSource(it, days, zipCode) }

    private fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList? {
        val res = source.requestForecastByZipCode(zipCode, todayTimeSpan())
        return if (res != null && res.size >= days) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}




