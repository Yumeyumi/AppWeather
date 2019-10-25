package com.utad.networking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.utad.networking.model.DetailCity

class DetailCity_Adapter(private val listener: (DetailCity) -> Unit) :
    RecyclerView.Adapter<com.utad.networking.DetailCity_Adapter.ViewHolder>() {

    private var cities = listOf<DetailCity>()

    fun addDetailcity(newCities: List<DetailCity>) {
        this.cities = newCities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = cities.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cities[position], listener)
    }

    class ViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {
        private val humidityTxt = view.findViewById<TextView>(R.id.humidity)
        private val max_tempTxt = view.findViewById<TextView>(R.id.max_temp)
        private val min_tempTxt = view.findViewById<TextView>(R.id.min_temp)
        private val the_tempTxt = view.findViewById<TextView>(R.id.the_temp)
        private val weather_state_nameTxt = view.findViewById<TextView>(R.id.weather_state_name)
        private val applicable_dateTxt = view.findViewById<TextView>(R.id.applicable_date)

        fun bind(detailCity: DetailCity, listener: (DetailCity) -> Unit) {
            humidityTxt.text = detailCity.humidity.toString()
            max_tempTxt.text = detailCity.max_temp.toString()
            min_tempTxt.text = detailCity.min_temp.toString()
            the_tempTxt.text = detailCity.the_temp.toString()
            weather_state_nameTxt.text = detailCity.weather_state_name
            applicable_dateTxt.text = detailCity.applicable_date

            this.itemView.setOnClickListener { listener.invoke(detailCity) }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.detail_city_item, parent, false)
                return ViewHolder(view)
            }
        }
    }

}