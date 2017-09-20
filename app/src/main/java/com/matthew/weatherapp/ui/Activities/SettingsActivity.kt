package com.matthew.weatherapp.ui.Activities

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_settings.*
import com.matthew.weatherapp.R
import com.matthew.weatherapp.domain.model.RequestForecastCommand
import com.matthew.weatherapp.extensions.DelegateExtensions
import com.matthew.weatherapp.ui.Adapters.ForecastListAdapter
import com.matthew.weatherapp.ui.utils.ToolbarManager
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class SettingsActivity : AppCompatActivity(), ToolbarManager {

    companion object {
        val ZIP_CODE = "zipCode"
        val DEFAULT_SIZE = 94043L
    }

    var zipCode: Long by DelegateExtensions.DelegatesExt.preference(this, ZIP_CODE, DEFAULT_SIZE);

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        cityCode.setText(zipCode.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed();
            true
        }
        else -> false


    }

    override fun onBackPressed() {
        super.onBackPressed()
        zipCode = cityCode.text.toString().toLong();
    }


}
