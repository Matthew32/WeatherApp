package com.matthew.weatherapp.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.matthew.weatherapp.data.db.tables.DataTables.*
import com.matthew.weatherapp.ui.App
import org.jetbrains.anko.db.*

/**
 * Created by Matthew on 19/09/2017.
 */
class ForecastDbHelper(ctx: Context = App.instance) :
        ManagedSQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION) {
    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(CityForecastTable.NAME, true,
                Pair(CityForecastTable.ID, INTEGER + PRIMARY_KEY),
                Pair(CityForecastTable.CITY, TEXT),
                Pair(CityForecastTable.COUNTRY, TEXT))
        db.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER
        )

    }

    companion object {
        val DB_NAME = "forecast.db";
        val DB_VERSION = 1;
        val instance by lazy { ForecastDbHelper() }
    }


//    public fun <T> use(f: SQLiteDatabase.() -> T): T {
//        try {
//            return openDatabase().f();
//        } finally {
//            closeDatabase();

//        }
//    }
//}
}
