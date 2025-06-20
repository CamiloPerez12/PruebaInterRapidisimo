package com.jcpd.pruebainterrapidisimo.presentation.home

import com.jcpd.pruebainterrapidisimo.data.models.UserModel

data class HomeScreenState (
    val version : String? = "",
    val userModel: UserModel? = null,
    val shouldDisplayDialog : Boolean = false,
    val error : Boolean = false,
    val loading : Boolean = true,
    val isVersionUp: Boolean = false,
    val errorMessage: String? = null,
    val isVersionDialog: Boolean = false
)
