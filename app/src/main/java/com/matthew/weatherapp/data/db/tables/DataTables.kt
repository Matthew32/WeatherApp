package com.matthew.weatherapp.data.db.tables

/**
 * Created by Matthew on 19/09/2017.
 */
class DataTables {
    object CityForecastTable {
        val NAME = "CityForecast";
        val ID = "_id";
        val CITY = "city";
        val COUNTRY = "country";

    }

    object DayForecastTable {

        val NAME = "DayForecast";
        val ID = "_id";
        val DATE = "date";
        val DESCRIPTION = "Description";
        val HIGH = "high";
        val LOW = "low";
        val ICON_URL = "iconUrl";
        val CITY_ID = "cityId";
    }
}