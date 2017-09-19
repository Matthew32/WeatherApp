package com.matthew.weatherapp.extensions

import kotlin.reflect.KProperty

/**
 * Created by Matthew on 19/09/2017.
 */
class DelegateExtensions {
    object DelegatesExt {
        fun <T> notNullSingleValue() = NotNullSingleValueVar<T>()
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