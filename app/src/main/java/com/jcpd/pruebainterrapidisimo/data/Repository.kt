package com.jcpd.pruebainterrapidisimo.data

import retrofit2.Response

interface Repository {

    suspend fun getVersion() : Response<String>
}