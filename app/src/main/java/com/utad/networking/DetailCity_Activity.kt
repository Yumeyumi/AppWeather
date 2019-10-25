package com.utad.networking
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.networking.data.RetrofitFactory
import kotlinx.android.synthetic.main.activity_detail_city_.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class DetailCity_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_city_)

        val idWeather: String = intent.extras?.getString("id").toString()
        detailCitiesRecyclerView.layoutManager = LinearLayoutManager(this)
        detailCitiesRecyclerView.setHasFixedSize(true)
        val detailCitiesAdapter = DetailCity_Adapter()
        detailCitiesRecyclerView.adapter = detailCitiesAdapter

        val weatherApi = RetrofitFactory.getWeatherApi()
        CoroutineScope(Dispatchers.IO).launch {
            val response = weatherApi.searchWeather(idWeather)
            withContext(Dispatchers.Main) {
                detailCitiesAdapter.addDetailcity(response.body()?.consolidated_weather!!)
            }
        }
    }
    }

