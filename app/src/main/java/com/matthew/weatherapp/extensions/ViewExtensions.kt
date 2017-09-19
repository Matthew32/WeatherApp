package com.matthew.weatherapp.extensions

import android.content.Context
import android.view.View

/**
 * Created by Matthew on 19/09/2017.
 */
class ViewExtensions {
    val View.ctx: Context
        get() = context
}