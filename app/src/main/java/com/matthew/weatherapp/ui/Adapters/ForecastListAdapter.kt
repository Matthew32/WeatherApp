package com.matthew.weatherapp.ui.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.matthew.weatherapp.R
import com.matthew.weatherapp.domain.model.Forecast
import com.matthew.weatherapp.domain.model.ForecastList
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import kotlinx.android.synthetic.main.forecast_list.*;
import kotlinx.android.synthetic.main.forecast_list.view.*

/**
 * Created by Matthew on 15/09/2017.
 */

class ForecastListAdapter(private val weekForecast: ForecastList,
                          val itemClick: (Forecast) -> Unit) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forecast_list, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.size

    class ViewHolder(view: View, val itemClick: (Forecast) -> Unit)
        : RecyclerView.ViewHolder(view) {
//
//        private val iconView = view.find<ImageView>(R.id.icon)
//        private val dateView = view.find<TextView>(R.id.date)
//        private val descriptionView = view.find<TextView>(R.id.description)
//        private val maxTemperatureView = view.find<TextView>(R.id.maxTemperature)
//        private val minTemperatureView = view.find<TextView>(R.id.minTemperature)

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.context).load(iconUrl).into(itemView.icon)
                itemView.date.text = date.toString()
                itemView.description.text = description
                itemView.maxTemperature.text = "${high}º"
                itemView.minTemperature.text = "${low}º"
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }


}
