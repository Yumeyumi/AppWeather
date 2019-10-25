package com.utad.networking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailCity_Activity : AppCompatActivity() {
    private lateinit var idWeather: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_city_)
        idWeather = findViewById(R.id.idWeather)
        idWeather.text = intent.extras?.getString("id")
    }
}
