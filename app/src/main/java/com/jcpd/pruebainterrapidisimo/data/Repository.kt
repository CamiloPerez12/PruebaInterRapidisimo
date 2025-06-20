package com.jcpd.pruebainterrapidisimo.data

import com.jcpd.pruebainterrapidisimo.data.models.TableModel
import com.jcpd.pruebainterrapidisimo.data.models.UserModel
import retrofit2.Response

interface Repository {

    suspend fun getVersion() : Response<String>
    suspend fun getLogin(): Response<UserModel>
    suspend fun getEsqueme(): Response<List<TableModel>>
}