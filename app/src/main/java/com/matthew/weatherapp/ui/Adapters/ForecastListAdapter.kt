package com.matthew.weatherapp.ui.Adapters

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.matthew.weatherapp.domain.model.ForecastList

/**
 * Created by Matthew on 15/09/2017.
 */
class ForecastListAdapter(val weekForecast: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context));
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast.get(position)) {
            holder.textview.text = "$date - $description - $high/$low";
        }
    }

    override fun getItemCount(): Int {
        return weekForecast.size;
    }

    class ViewHolder(val textview: TextView) : RecyclerView.ViewHolder(textview);
}
