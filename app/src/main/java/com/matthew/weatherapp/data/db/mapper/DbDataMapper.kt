package com.matthew.weatherapp.data.db.mapper

import com.matthew.weatherapp.data.db.model.CityForecast
import com.matthew.weatherapp.data.db.model.DayForecast
import com.matthew.weatherapp.domain.model.Forecast
import com.matthew.weatherapp.domain.model.ForecastList

/**
 * Created by Matthew on 19/09/2017.
 */
class DbDataMapper {

    fun convertFromDomain(forecast: ForecastList) = with(forecast) {
        val daily = dailyForecast.map { convertDayFromDomain(1, it) }
        //id: Long, city: String, country: String, dailyForecast: List<DayForecast>
        CityForecast(1, city, country, daily)
    }

    private fun convertDayFromDomain(cityId: Long, forecast: Forecast) = with(forecast) {
        DayForecast(date.toLong(), description, high, low, iconUrl, cityId)
    }

    fun convertToDomain(forecast: CityForecast) = with(forecast) {
        val daily = dailyForecast.map { convertDayToDomain(it) }
        ForecastList(city, country, daily)
        //(val city: String, val country: String, val dailyForecast: List<Forecast>
    }

    private fun convertDayToDomain(dayForecast: DayForecast) = with(dayForecast) {
        Forecast(date.toString(), description, high, low, iconUrl)
        //val id: Long, val date: String, val description: String, val high: Int, val low: Int, val iconUrl: String
    }
}