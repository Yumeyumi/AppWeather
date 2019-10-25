package com.utad.networking

import android.content.Intent
import android.os.Bundle
import android.widget.SearchView
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
    private lateinit var cityName: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val CitySearch = findViewById<SearchView>(R.id.searchView)
        citiesRecyclerView.layoutManager = LinearLayoutManager(this)
        citiesRecyclerView.setHasFixedSize(true)
        val citiesAdapter = CitiesAdapter {
            val intent = Intent(this, DetailCity_Activity::class.java)
            intent.putExtra("id",it.woeid )
            startActivity(intent)

        }
        citiesRecyclerView.adapter = citiesAdapter
        CitySearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(query: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(text: String): Boolean {
                cityName = text
                val weatherApi = RetrofitFactory.getWeatherApi()
                CoroutineScope(Dispatchers.IO).launch {
                    val response = weatherApi.searchCities(cityName)
                    withContext(Dispatchers.Main) {
                        citiesAdapter.addCities(response.body()!!)
                    }
                }
                return false
            }
        })


    }


}
