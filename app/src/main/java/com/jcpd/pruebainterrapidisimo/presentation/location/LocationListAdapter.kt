package com.jcpd.pruebainterrapidisimo.presentation.location

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jcpd.pruebainterrapidisimo.R
import com.jcpd.pruebainterrapidisimo.data.models.LocationsModel

class LocationListAdapter (private val tableList: List<LocationsModel>) :
RecyclerView.Adapter<LocationListAdapter.LocationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.location_item, parent, false)
        return LocationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val currentItem = tableList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = tableList.size

    inner class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val locationName: TextView = itemView.findViewById(R.id.locationName)
        private val locationCity: TextView = itemView.findViewById(R.id.locationCity)


        fun bind(locationsModel: LocationsModel){
            locationName.text = locationsModel.locationName
            locationCity.text = locationsModel.locationCity
        }
    }
}
