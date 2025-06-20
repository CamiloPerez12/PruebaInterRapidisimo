package com.jcpd.pruebainterrapidisimo.data

import com.jcpd.pruebainterrapidisimo.data.models.LocationsModel
import com.jcpd.pruebainterrapidisimo.data.models.TableModel
import com.jcpd.pruebainterrapidisimo.data.models.UserModel
import retrofit2.Response

interface Repository {

    suspend fun getVersion() : Response<String>
    suspend fun getLogin(): Response<UserModel>
    suspend fun getEsqueme(): Response<List<TableModel>>
    suspend fun getLocations(): Response<List<LocationsModel>>
    suspend fun getTables(): List<TableModel>
    suspend fun setTables(tableModel : TableModel): Long
    suspend fun deleteTables(): Int
}