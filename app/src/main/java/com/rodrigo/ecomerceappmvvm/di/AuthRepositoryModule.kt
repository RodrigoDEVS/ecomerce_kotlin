package com.rodrigo.ecomerceappmvvm.di

import com.google.firebase.auth.FirebaseAuth
import com.rodrigo.ecomerceappmvvm.data.repository.AuthRepositoryImpl
import com.rodrigo.ecomerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.rodrigo.ecomerceappmvvm.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthRepositoryModule {

    @Provides
    fun provideAuthRepository(authRemoteDataSource: AuthRemoteDataSource): AuthRepository = AuthRepositoryImpl(authRemoteDataSource)
}