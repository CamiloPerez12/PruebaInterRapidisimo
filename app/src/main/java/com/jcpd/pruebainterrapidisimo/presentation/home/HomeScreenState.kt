package com.jcpd.pruebainterrapidisimo.presentation.home

import com.jcpd.pruebainterrapidisimo.data.models.UserModel

data class HomeScreenState (
    val version : String? = "",
    val userModel: UserModel? = null,
    val alertDialogShowned : Boolean = false,
    val error : Boolean = false,
    val loading : Boolean = true
)
