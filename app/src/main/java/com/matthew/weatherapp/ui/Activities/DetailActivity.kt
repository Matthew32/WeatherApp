package com.matthew.weatherapp.ui.Activities

import android.content.Context
import  android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import com.matthew.weatherapp.R
import com.matthew.weatherapp.domain.model.Forecast
import com.matthew.weatherapp.domain.model.RequestDayForecastCommand
import com.matthew.weatherapp.extensions.color
import com.matthew.weatherapp.extensions.textColor
import com.matthew.weatherapp.extensions.toDateString
import com.squareup.picasso.Picasso
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.forecast_list.*
import org.jetbrains.anko.ctx
import java.text.DateFormat

class DetailActivity : AppCompatActivity() {
    companion object {
        val ID = "DetailActivity:id"
        val CITY_NAME = "DetailActivity:cityName"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        title = intent.getStringExtra(CITY_NAME);
        doAsync {
            val result = RequestDayForecastCommand(intent.getLongExtra(ID, -1)).execute();
            uiThread {
                bindForecast(result)
            }

        }
    }

    private fun bindForecast(forecast: Forecast) = with(forecast) {
        Picasso.with(ctx).load(iconUrl).into(iconDetail);
        supportActionBar?.subtitle = date.toDateString(DateFormat.FULL);
        weatherDescriptionDetail.text = description;
        bindWeather(high to maxTemperatureDetail, low to minTemperatureDetail)

    }

    private fun bindWeather(vararg views: Pair<Int, TextView>) = views.forEach {
        it.second.text = "${it.first.toString()}"
        it.second.textColor = color(when (it.first) {
            in -50..0 -> android.R.color.holo_red_dark
            in 0..15 -> android.R.color.holo_orange_dark
            else -> android.R.color.holo_green_dark

        })
    }


}
