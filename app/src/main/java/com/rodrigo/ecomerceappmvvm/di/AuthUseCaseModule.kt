package com.rodrigo.ecomerceappmvvm.di

import com.rodrigo.ecomerceappmvvm.domain.repository.AuthRepository
import com.rodrigo.ecomerceappmvvm.domain.useCase.auth.AuthUseCase
import com.rodrigo.ecomerceappmvvm.domain.useCase.auth.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthUseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(login = LoginUseCase(authRepository))
}