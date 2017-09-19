package com.matthew.weatherapp.extensions

/**
 * Created by Matthew on 19/09/2017.
 */


    fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
            map({ Pair(it.key, it.value!!) }).toTypedArray()
