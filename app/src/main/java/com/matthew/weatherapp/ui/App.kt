package com.matthew.weatherapp.ui

import android.app.Application
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Created by Matthew on 19/09/2017.
 */
class App : Application() {
    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
        //        private var instance: Application? = null;
//        fun instance() = instance!!;

    }

    object DelegatesExt {
        fun <T> notNullSingleValue() = NotNullSingleValueVar<T>();
    }



    override fun onCreate() {
        super.onCreate();
        instance = this;

    }


}