package com.matthew.weatherapp.ui.Activities

import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Build
import com.matthew.weatherapp.data.Request
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.matthew.weatherapp.ui.Adapters.ForecastListAdapter
import com.matthew.weatherapp.R
import com.matthew.weatherapp.domain.model.Forecast
//import com.matthew.weatherapp.domain.model.Forecast
import com.matthew.weatherapp.domain.model.RequestForecastCommand
import com.matthew.weatherapp.ui.utils.ForecastDbHelper
import com.matthew.weatherapp.ui.utils.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.forecast_list.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
    private val items = listOf("Mon 6/23 - Sunny 31/17", "Tue 6/24 - Foggy - 21/8", "Wed 6/25 - Cloudy - 22/17", "Thurs 6/26 - Rainy - 18/11", "Fri 6/27 - Foggy - 21/10", "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18", "Sun 6/29 - Sunny - 20/7")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this);
        // forecastList.adapter = ForecastListAdapter(weekForecast);

        message.text = "dddd"; // change  TextView Text
        toast("ASDF"); // methods
//        niceToast("COSA", "TAG"); // two parameters
//        niceToast("COSA"); // only one parameter
//        niceToast(message = "d", length = 5);// declare methods variable right here
//
//        toast("COSA", Toast.LENGTH_LONG);
        val url = "http://api.openweathermap.org/data/2.5/forecast_list/daily?" +
                "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"
        //make asyntask
        doAsync {
            Request(url).run();
            uiThread { longToast("Request Performed") }
        }
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
                forecastList.adapter = ForecastListAdapter(result) { forecast -> toast(forecast.date) };

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
}
