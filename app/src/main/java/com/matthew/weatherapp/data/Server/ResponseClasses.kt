package com.matthew.weatherapp.data.Server

import com.matthew.weatherapp.data.Example.Forecast

/**
 * Created by Matthew on 18/09/2017.
 */
class ResponseClasses {
    data class ForecastResult(val city: City, val list: List<Forecast>)
    data class City(val id: Long, val name: String, val coord: Coordinates, val country: String, val population: Int)

    data class Coordinates(val lon: Float, val lat: Float)



    data class Temperature(val day:Float , val min : Float , val max:Float , val night:Float ,
                           val deg:Int , val clouds :Int , val rain : Float )

    data class Weather(val id : Long , val main :String , val description : String , val icon : String)
}