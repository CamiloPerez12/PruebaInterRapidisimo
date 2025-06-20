package com.jcpd.pruebainterrapidisimo.data.models

import com.google.gson.annotations.SerializedName

data class UserModel(
    @SerializedName("Usuario") val user: String,
    @SerializedName("Identificacion") val id: String,
    @SerializedName("Nombre") val name: String
)