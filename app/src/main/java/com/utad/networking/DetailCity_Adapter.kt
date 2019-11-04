package com.utad.networking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.utad.networking.model.DetailCity
import com.utad.networking.model.DetailWeather

class DetailCity_Adapter() : RecyclerView.Adapter<com.utad.networking.DetailCity_Adapter.ViewHolder>() {

    private var detailWeather = listOf<DetailWeather>()

    fun addDetailcity(newdetailWeather: List<DetailWeather>) {
        this.detailWeather = newdetailWeather
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = detailWeather.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(detailWeather[position])
    }

    class ViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {

        private val humidityTxt = view.findViewById<TextView>(R.id.humidity)
        private val max_tempTxt = view.findViewById<TextView>(R.id.max_temp)
        private val min_tempTxt = view.findViewById<TextView>(R.id.min_temp)
        private val the_tempTxt = view.findViewById<TextView>(R.id.the_temp)
        private val weather_state_nameTxt = view.findViewById<TextView>(R.id.weather_state_name)
        private val applicable_dateTxt = view.findViewById<TextView>(R.id.applicable_date)


        fun bind(detailWeather: DetailWeather) {
            humidityTxt.text = detailWeather.humidity.toString()
            max_tempTxt.text = detailWeather.max_temp.toString()
            min_tempTxt.text = detailWeather.min_temp.toString()
            the_tempTxt.text = detailWeather.the_temp.toString()
            weather_state_nameTxt.text = detailWeather.weather_state_name
            applicable_dateTxt.text = detailWeather.applicable_date

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