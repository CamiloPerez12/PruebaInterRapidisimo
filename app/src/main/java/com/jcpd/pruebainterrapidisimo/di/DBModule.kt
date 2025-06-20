package com.jcpd.pruebainterrapidisimo.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.jcpd.pruebainterrapidisimo.data.local.DatabaseHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabaseHelper(@ApplicationContext appContext: Context): DatabaseHelper {
        return DatabaseHelper(appContext)
    }

    @Provides@Singleton
    fun provideWritableDatabase(dbHelper: DatabaseHelper): SQLiteDatabase {
        return dbHelper.writableDatabase}

}