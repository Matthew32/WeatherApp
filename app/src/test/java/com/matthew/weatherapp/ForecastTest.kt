package com.matthew.weatherapp

import com.matthew.weatherapp.data.Server.ForecastServer
import com.matthew.weatherapp.data.db.ForecastDb
import com.matthew.weatherapp.domain.datasource.ForecastDataSource
import com.matthew.weatherapp.domain.datasource.ForecastProvider
import com.matthew.weatherapp.domain.model.Forecast
import com.matthew.weatherapp.domain.model.ForecastList
import org.junit.Test
import kotlin.test.assertNotNull
import org.mockito.Mockito.*
import org.mockito.Mockito.`when` as whenever;

/**
 * Created by Matthew on 20/09/2017.
 */
class ForecastTest {
    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24;
        val SOURCES by lazy { listOf(ForecastDb(), ForecastServer()) }

    }

    @Test
    fun testDataSourceReturnValue() {
        val ds = mock(ForecastDataSource::class.java)
        whenever(ds.requestDayForecast(0)).then {
            Forecast(0, 0, "desc", 20, 0, "url")
        }
        val provider = ForecastProvider(listOf(ds))
        assertNotNull(provider.requestForecast(0))
    }

    @Test
    fun emptyDatabaseReturnServerValue() {
        val db = mock(ForecastDataSource::class.java);
        val server = mock(ForecastDataSource::class.java)
        whenever(server.requestForecastByZipCode(any(Long::class.java), any(Long::class.java))).then {
            ForecastList("city", "country", listOf())
        }
        val provider = ForecastProvider(listOf(db, server))
        assertNotNull(provider.requestByZipCode(0, 0))
    }


}