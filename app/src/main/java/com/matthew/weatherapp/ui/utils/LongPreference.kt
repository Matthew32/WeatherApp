package com.matthew.weatherapp.ui.utils

import android.content.Context
import kotlin.reflect.KProperty

/**
 * Created by Matthew on 20/09/2017.
 */
class LongPreference(val context: Context, val name: String, val default: Long) {
    val prefs by lazy {
        context.getSharedPreferences("default", Context.MODE_PRIVATE)


    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Long {
        return prefs.getLong(name, default)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Long) {
        prefs.edit().putLong(name, value).apply();
    }
}