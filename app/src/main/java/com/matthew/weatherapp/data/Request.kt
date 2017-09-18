package com.matthew.weatherapp.data

import android.util.Log
import java.net.URL


/**
 * Created by Matthew on 18/09/2017.
 */
class Request(val url : String) {
    fun run(){
        val forecastJsonStr = URL(url).readText();
        Log.d(javaClass.simpleName , forecastJsonStr);
    }


}