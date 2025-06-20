package com.jcpd.pruebainterrapidisimo.data

import com.jcpd.pruebainterrapidisimo.data.local.TableModelDao
import com.jcpd.pruebainterrapidisimo.data.models.LocationsModel
import com.jcpd.pruebainterrapidisimo.data.models.TableModel
import com.jcpd.pruebainterrapidisimo.data.models.UserModel
import com.jcpd.pruebainterrapidisimo.data.network.NetworkDataSource
import retrofit2.Response
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val tableModelDao: TableModelDao
): Repository {
    override suspend fun getVersion(): Response<String> {
        return networkDataSource.getVersion()
    }
    override suspend fun getLogin(): Response<UserModel> {
        return networkDataSource.getLogin()
    }
    override suspend fun getEsqueme(): Response<List<TableModel>> {
        return networkDataSource.getEsqueme()
    }
    override suspend fun getLocations(): Response<List<LocationsModel>> {
        return networkDataSource.getLocations()
    }
    override suspend fun getTables(): List<TableModel> {
        return tableModelDao.getAllTableModels()
    }
    override suspend fun setTables(tableModel : TableModel): Long {
        return tableModelDao.insertTableModel(tableModel)
    }
    override suspend fun deleteTables(): Int {
        return tableModelDao.deleteAllTableModels()
    }
}