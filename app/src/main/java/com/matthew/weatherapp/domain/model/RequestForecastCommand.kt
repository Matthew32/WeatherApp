package com.matthew.weatherapp.domain.model

import android.os.Build
import android.support.annotation.RequiresApi
import com.matthew.weatherapp.data.ForecastRequest
import com.matthew.weatherapp.domain.mappers.ForecastDataMapper

/**
 * Created by Matthew on 18/09/2017.
 */
class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun execute(): ForecastList {
        val forecastRequest  = ForecastRequest(zipCode);
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }

}