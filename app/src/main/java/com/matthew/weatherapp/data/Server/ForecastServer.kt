package com.matthew.weatherapp.data.Server

import android.annotation.TargetApi
import android.os.Build
import android.support.annotation.RequiresApi
import com.matthew.weatherapp.data.db.ForecastDb
import com.matthew.weatherapp.domain.model.ForecastDataSource
import com.matthew.weatherapp.domain.model.ForecastList
import com.matthew.weatherapp.domain.model.RequestForecastCommand

/**
 * Created by Matthew on 19/09/2017.
 */
class ForecastServer(private val dataMapper: ServerDataMapper = ServerDataMapper(),
                     private val forecastDb: ForecastDb = ForecastDb()) : ForecastDataSource {
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(Build.VERSION_CODES.N)
    override fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList? {
        var result = ForecastByZipCodeRequest(zipCode).execute();
        var converted = dataMapper.convertToDomain(zipCode, result);
        forecastDb.saveForecast(converted);
        return forecastDb.requestForecastByZipCode(zipCode, date);
    }

}

