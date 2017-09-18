package com.matthew.weatherapp.data

/**
 * Created by Matthew on 18/09/2017.
 */
import com.google.gson.Gson
import java.net.URL
class ForecastRequest( val zipCode :String) {
    //singleton
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce";
        private val URL = "http://api.openweathermap.org/data/2.5/forecast_list/daily?";
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q=";
    }
    fun execute() : ResponseClasses.ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText();
        return Gson().fromJson(forecastJsonStr,ResponseClasses.ForecastResult::class.java);
    }

}