package com.jcpd.pruebainterrapidisimo.data.network

import retrofit2.Response
import retrofit2.http.GET

interface NetworkDataSource {

    @GET("apicontrollerpruebas/api/ParametrosFramework/ConsultarParametrosFramework/VPStoreAppControl")
    suspend fun getVersion(): Response<String>
}