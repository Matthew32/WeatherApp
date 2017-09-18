package com.matthew.weatherapp.domain.mappers

import android.icu.text.DateFormat
import android.os.Build
import android.support.annotation.RequiresApi
import com.matthew.weatherapp.data.Forecast
import com.matthew.weatherapp.data.ResponseClasses
import com.matthew.weatherapp.domain.model.ForecastList
import java.util.*
import java.util.concurrent.TimeUnit
import com.matthew.weatherapp.domain.model.Forecast as ModelForecast

/**
 * Created by Matthew on 18/09/2017.
 */
class ForecastDataMapper {

    @RequiresApi(Build.VERSION_CODES.N)
    fun convertFromDataModel(forecast: ResponseClasses.ForecastResult): ForecastList {

        return ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun convertForecastListToDomain(list: List<com.matthew.weatherapp.data.Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())

            convertForecastItemToDomain(forecast.copy(dt = dt));
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(), forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon));

    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date);

    }

    private fun generateIconUrl(icon: String): String = "http://openweather.org/img/w/$icon.png"

}