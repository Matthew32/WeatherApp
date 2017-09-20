package com.matthew.weatherapp

import com.matthew.weatherapp.domain.datasource.ForecastProvider
import com.matthew.weatherapp.domain.model.RequestDayForecastCommand
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.Mockito.`when` as whenever;

/**
 * Created by Matthew on 20/09/2017.
 */
class RequestDayForecastCommandTest {
    @Test
    fun testProviderIsCalled() {
        val forecastProvider = mock(ForecastProvider::class.java)
        val command = RequestDayForecastCommand(2, forecastProvider);
        command.execute();
        verify(forecastProvider).requestForecast(2)
    }
}