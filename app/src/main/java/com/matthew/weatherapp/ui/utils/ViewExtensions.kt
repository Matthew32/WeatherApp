package com.matthew.weatherapp.ui.utils


import android.content.Context
import android.view.View

/**
 * Created by Matthew on 18/09/2017.
 */
interface ViewExtensions {
    val View.ctx: Context
        get() = context;

}