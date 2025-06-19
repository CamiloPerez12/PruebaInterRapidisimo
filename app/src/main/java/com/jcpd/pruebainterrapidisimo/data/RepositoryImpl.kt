package com.jcpd.pruebainterrapidisimo.data

import com.jcpd.pruebainterrapidisimo.data.network.NetworkDataSource
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource
): Repository {
    override suspend fun getVersion() : Response<String> {
        return networkDataSource.getVersion()
    }
}