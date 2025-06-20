package com.jcpd.pruebainterrapidisimo.data.models

import com.google.gson.annotations.SerializedName

data class LocationsModel(
   @SerializedName("NombreCompleto") val locationName : String,
   @SerializedName("AbreviacionCiudad") val locationCity : String,
)
