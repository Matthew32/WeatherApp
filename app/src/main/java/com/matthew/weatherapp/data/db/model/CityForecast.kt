package com.matthew.weatherapp.data.db.model

/**
 * Created by Matthew on 19/09/2017.
 */
class CityForecast(val map: MutableMap<String, Any?>, val dailyForecast: List<DayForecast>) {

    var _id: Long by map;
    var city: String by map;
    var country: String by map;

    constructor(id: Long, city: String, country: String, dailyForecast: List<DayForecast>) : this(HashMap(), dailyForecast) {
        this._id = id;
        this.city = city;
        this.country = country;
    }

}