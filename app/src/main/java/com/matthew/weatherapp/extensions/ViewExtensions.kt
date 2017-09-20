package com.matthew.weatherapp.extensions

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView

/**
 * Created by Matthew on 19/09/2017.
 */

val View.ctx: Context
    get() = context

public fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)

var TextView.textColor: Int
    get() = currentTextColor
    set(v) = setTextColor(v)
