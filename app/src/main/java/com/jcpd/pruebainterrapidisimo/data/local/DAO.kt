package com.jcpd.pruebainterrapidisimo.data.local

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.jcpd.pruebainterrapidisimo.data.local.TableContract.TableModelEntry
import com.jcpd.pruebainterrapidisimo.data.models.TableModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TableModelDao @Inject constructor(
    private val db: SQLiteDatabase
) {

    fun insertTableModel(tableModel: TableModel): Long {
        val values = ContentValues().apply {
            put(TableModelEntry.COLUMN_NAME_TABLE_NAME, tableModel.tableName)
            put(TableModelEntry.COLUMN_NAME_PRIMARY_KEY, tableModel.primaryKey)
            put(TableModelEntry.COLUMN_NAME_QUERY_CREATION, tableModel.queryCreation)
            put(TableModelEntry.COLUMN_NAME_BATCH_SIZE, tableModel.batchSize)
            put(TableModelEntry.COLUMN_NAME_FILTER, tableModel.filter)
            put(TableModelEntry.COLUMN_NAME_ERROR, tableModel.error)
            put(TableModelEntry.COLUMN_NAME_NUMBER_FIELD, tableModel.numberField)
            put(TableModelEntry.COLUMN_NAME_APP_METHOD, tableModel.appMethod)
            put(TableModelEntry.COLUMN_NAME_UPDATED_DATE_SYNC, tableModel.updatedDateSync)
        }
        return db.insert(TableModelEntry.TABLE_NAME, null, values)
    }

    fun getAllTableModels(): List<TableModel> {
        val tableModels = mutableListOf<TableModel>()
        val cursor: Cursor? = db.query(
            TableModelEntry.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )

        cursor?.use {
            while (it.moveToNext()) {
                val tableName =
                    it.getString(it.getColumnIndexOrThrow(TableModelEntry.COLUMN_NAME_TABLE_NAME))
                val primaryKey =
                    it.getString(it.getColumnIndexOrThrow(TableModelEntry.COLUMN_NAME_PRIMARY_KEY))
                val queryCreation =
                    it.getString(it.getColumnIndexOrThrow(TableModelEntry.COLUMN_NAME_QUERY_CREATION))
                val batchSize =
                    it.getInt(it.getColumnIndexOrThrow(TableModelEntry.COLUMN_NAME_BATCH_SIZE))
                val filter =
                    it.getString(it.getColumnIndexOrThrow(TableModelEntry.COLUMN_NAME_FILTER))
                val error =
                    it.getString(it.getColumnIndexOrThrow(TableModelEntry.COLUMN_NAME_ERROR))
                val numberField =
                    it.getInt(it.getColumnIndexOrThrow(TableModelEntry.COLUMN_NAME_NUMBER_FIELD))
                val appMethod =
                    it.getString(it.getColumnIndexOrThrow(TableModelEntry.COLUMN_NAME_APP_METHOD))
                val updatedDateSync =
                    it.getString(it.getColumnIndexOrThrow(TableModelEntry.COLUMN_NAME_UPDATED_DATE_SYNC))

                tableModels.add(
                    TableModel(
                        tableName, primaryKey, queryCreation, batchSize, filter,
                        error, numberField, appMethod, updatedDateSync
                    )
                )
            }
        }
        return tableModels
    }

    fun deleteAllTableModels(): Int {
        return db.delete(TableModelEntry.TABLE_NAME, null, null)
    }

}