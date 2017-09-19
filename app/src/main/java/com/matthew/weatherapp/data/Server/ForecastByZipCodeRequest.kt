package com.matthew.weatherapp.data.Server

import com.google.gson.Gson

/**
 * Created by Matthew on 20/09/2017.
 */
class ForecastByZipCodeRequest(private val zipCode: Long, val gson: Gson = Gson()) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce";
        private val URL = "http://api.openweathermap.org/data/2.5/forecast_list/daily?";
        private val COMPLETE_URL = "${URL}&APPID=${APP_ID}&q=";
    }
    fun execute() : ForecastResult {
        val forecastJsonStr = java.net.URL(COMPLETE_URL + zipCode).readText();
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java);
    }
}