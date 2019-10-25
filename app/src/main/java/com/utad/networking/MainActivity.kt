package com.utad.networking

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.utad.networking.data.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        citiesRecyclerView.layoutManager = LinearLayoutManager(this)
        citiesRecyclerView.setHasFixedSize(true)
        val citiesAdapter = CitiesAdapter {
            val intent = Intent(this, DetailCity_Activity::class.java)
            intent.putExtra("id",it.woeid )
            startActivity(intent)

        }
        citiesRecyclerView.adapter = citiesAdapter

        val weatherApi = RetrofitFactory.getWeatherApi()
        CoroutineScope(Dispatchers.IO).launch {
            val response = weatherApi.searchCities()
            withContext(Dispatchers.Main) {
                citiesAdapter.addCities(response.body()!!)
            }
        }
    }
}
