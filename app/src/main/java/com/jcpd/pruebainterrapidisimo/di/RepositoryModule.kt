package com.jcpd.pruebainterrapidisimo.di

import com.jcpd.pruebainterrapidisimo.data.Repository
import com.jcpd.pruebainterrapidisimo.data.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsRepository(repo: RepositoryImpl): Repository
}
