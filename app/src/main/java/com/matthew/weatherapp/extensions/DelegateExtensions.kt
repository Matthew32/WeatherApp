package com.matthew.weatherapp.extensions

import android.content.Context
import com.matthew.weatherapp.ui.utils.LongPreference
import com.matthew.weatherapp.ui.utils.Preference
import kotlin.reflect.KProperty

/**
 * Created by Matthew on 19/09/2017.
 */
class DelegateExtensions {
    object DelegatesExt {
        fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
        fun <T> preference(context: Context, name: String, default: T) = Preference(context, name, default);
    }

    class NotNullSingleValueVar<T> {

        private var value: T? = null

        operator fun getValue(thisRef: Any?, property: KProperty<*>): T =
                value ?: throw IllegalStateException("${property.name} not initialized")

        operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
            this.value = if (this.value == null) value
            else throw IllegalStateException("${property.name} already initialized")
        }
    }
}