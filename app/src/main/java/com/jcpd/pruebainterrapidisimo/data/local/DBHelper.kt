package com.jcpd.pruebainterrapidisimo.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

object TableContract {
    object TableModelEntry : BaseColumns {
        const val TABLE_NAME = "table_metadata"
        const val COLUMN_NAME_TABLE_NAME = "table_definition_name"
        const val COLUMN_NAME_PRIMARY_KEY = "primary_key_definition"
        const val COLUMN_NAME_QUERY_CREATION = "query_creation"
        const val COLUMN_NAME_BATCH_SIZE = "batch_size"
        const val COLUMN_NAME_FILTER = "filter_definition"
        const val COLUMN_NAME_ERROR = "error_message"
        const val COLUMN_NAME_NUMBER_FIELD = "number_of_fields"
        const val COLUMN_NAME_APP_METHOD = "app_method"
        const val COLUMN_NAME_UPDATED_DATE_SYNC = "updated_date_sync"

        const val SQL_CREATE_TABLE =
            "CREATE TABLE $TABLE_NAME (" +
                    "${BaseColumns._ID} INTEGER PRIMARY KEY," +
                    "$COLUMN_NAME_TABLE_NAME TEXT NOT NULL," +
                    "$COLUMN_NAME_PRIMARY_KEY TEXT NOT NULL," +
                    "$COLUMN_NAME_QUERY_CREATION TEXT NOT NULL," +
                    "$COLUMN_NAME_BATCH_SIZE INTEGER NOT NULL," +
                    "$COLUMN_NAME_FILTER TEXT NOT NULL," +
                    "$COLUMN_NAME_ERROR TEXT," +
                    "$COLUMN_NAME_NUMBER_FIELD INTEGER NOT NULL," +
                    "$COLUMN_NAME_APP_METHOD TEXT," +
                    "$COLUMN_NAME_UPDATED_DATE_SYNC TEXT NOT NULL)"

        const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(TableContract.TableModelEntry.SQL_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.let {
            it.execSQL(TableContract.TableModelEntry.SQL_DELETE_TABLE)
            onCreate(it)
        }
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "InterRapidisimo.db"
    }
}