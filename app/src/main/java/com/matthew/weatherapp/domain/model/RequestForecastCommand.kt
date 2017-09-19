package com.matthew.weatherapp.domain.model

import android.os.Build
import android.support.annotation.RequiresApi
import com.matthew.weatherapp.domain.datasource.ForecastProvider

/**
 * Created by Matthew on 18/09/2017.
 */
class RequestForecastCommand(val zipCode: String, val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {


    companion object {
        val DAYS = 7;
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun execute(): ForecastList {
        //   val forecastRequest = ForecastRequest(zipCode);
        //    return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
        return forecastProvider.requestByZipCode(zipCode.toLong(), DAYS)
    }

}