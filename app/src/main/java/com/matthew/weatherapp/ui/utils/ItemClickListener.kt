package com.matthew.weatherapp.ui.utils

import com.matthew.weatherapp.domain.model.Forecast

/**
 * Created by Matthew on 18/09/2017.
 */
interface OnItemClickListener {
    operator fun invoke(forecast: Forecast)
}