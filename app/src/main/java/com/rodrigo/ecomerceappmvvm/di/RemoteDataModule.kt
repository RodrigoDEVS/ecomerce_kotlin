package com.rodrigo.ecomerceappmvvm.di

import com.rodrigo.ecomerceappmvvm.data.api.AuthService
import com.rodrigo.ecomerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.rodrigo.ecomerceappmvvm.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)
}