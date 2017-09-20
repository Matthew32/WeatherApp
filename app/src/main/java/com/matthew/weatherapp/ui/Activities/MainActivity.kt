package com.matthew.weatherapp.ui.Activities

import android.annotation.TargetApi
import android.app.Activity
import android.content.Intent
import android.os.Build
import com.matthew.weatherapp.data.Server.Request
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.matthew.weatherapp.ui.Adapters.ForecastListAdapter
import com.matthew.weatherapp.R
//import com.matthew.weatherapp.domain.model.Forecast
import com.matthew.weatherapp.domain.model.RequestForecastCommand
import com.matthew.weatherapp.data.db.ForecastDbHelper
import com.matthew.weatherapp.domain.model.ForecastList
import com.matthew.weatherapp.extensions.DelegateExtensions
import com.matthew.weatherapp.ui.utils.ToolbarManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.*
import org.jetbrains.anko.coroutines.experimental.asReference
import org.jetbrains.anko.coroutines.experimental.bg
import kotlin.jvm.javaClass;

class MainActivity : AppCompatActivity(), ToolbarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }
    var zipCode: Long by DelegateExtensions.DelegatesExt.preference(this, SettingsActivity.ZIP_CODE, SettingsActivity.DEFAULT_SIZE);

    private lateinit var instance: Activity;
    private val items = listOf("Mon 6/23 - Sunny 31/17", "Tue 6/24 - Foggy - 21/8", "Wed 6/25 - Cloudy - 22/17", "Thurs 6/26 - Rainy - 18/11", "Fri 6/27 - Foggy - 21/10", "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18", "Sun 6/29 - Sunny - 20/7")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initToolbar();
        instance = this;
        forecastList.layoutManager = LinearLayoutManager(this);
        // forecastList.adapter = ForecastListAdapter(weekForecast);

        toast("ASDF"); // methods
//        niceToast("COSA", "TAG"); // two parameters
//        niceToast("COSA"); // only one parameter
//        niceToast(message = "d", length = 5);// declare methods variable right here
//
//        toast("COSA", Toast.LENGTH_LONG);
//        val url = "http://api.openweathermap.org/data/2.5/forecast_list/daily?" +
//                "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"
        //make asyntask
//        doAsync {
//            Request(url).run();
//            uiThread { longToast("Request Performed") }
//        }
        //Example code for copy objects
        // val f1  = Forecast(Date(), 27.5f, "Shiny day");
        // val (date, temperature , details ) = f1;
        /* compiled too
        val date = f1.component1();
        val temperature = f1.component2();
        val details = f1.component3();
         */
        // val f2 = f1.copy(temperature = 30f);
        doAsync {
            val result = RequestForecastCommand("94043").execute();
            uiThread {
                val adapter = ForecastListAdapter(result) {
                    startActivity<DetailActivity>(DetailActivity.ID to it.id,
                            DetailActivity.CITY_NAME to result.city)
                };
                forecastList.adapter = adapter;
                toolbarTitle = "{${result.city} (${result.country})"
            }

        }


    }

    //examples to call to db
    var dbHelper1 = ForecastDbHelper();
    var dbHelper2 = ForecastDbHelper(this)


    fun add(x: Int, y: Int): Int {
        return x + y;
    }

    fun addExample2(x: Int, y: Int): Int = x + y;
    //code for x version example

    inline fun supportsLollipop(code: () -> Unit) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            code();

        }
    }

    //    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
//        Toast.makeText(this, message, length).show();
//    }
//
//    fun niceToast(message: String, tag: String = MainActivity::class.java.simpleName, length: Int = Toast.LENGTH_SHORT) {
//        Toast.makeText(this, "[$tag]  $message", length).show();
//    }
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onResume() {
        super.onResume()
        loadForecast();
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadForecast() {
        val ref = asReference();
        val localZipCode = zipCode;
        async(kotlinx.coroutines.experimental.android.UI) {
            val result = bg { RequestForecastCommand(localZipCode.toString()).execute() }
            val weekForecast = result.await();
            ref().updateUI(weekForecast);
        }
    }

    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateUI(result: ForecastList) {
        doAsync {

            uiThread {
                val adapter = ForecastListAdapter(result) {
                    startActivity<DetailActivity>(DetailActivity.ID to it.id,
                            DetailActivity.CITY_NAME to result.city)
                };
                forecastList.adapter = adapter;
                toolbarTitle = "{${result.city} (${result.country})"
            }

        }
    }


}

