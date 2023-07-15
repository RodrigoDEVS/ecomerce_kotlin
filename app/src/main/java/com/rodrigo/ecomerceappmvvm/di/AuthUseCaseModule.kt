package com.rodrigo.ecomerceappmvvm.di

import com.rodrigo.ecomerceappmvvm.domain.repository.AuthRepository
import com.rodrigo.ecomerceappmvvm.domain.useCase.auth.AuthUseCase
import com.rodrigo.ecomerceappmvvm.domain.useCase.auth.LoginUseCase
import com.rodrigo.ecomerceappmvvm.domain.useCase.auth.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthUseCaseModule {

    @Provides
    fun provideAuthUseCase(authRepository: AuthRepository) = AuthUseCase(
        login = LoginUseCase(authRepository),
        register = RegisterUseCase(authRepository)
    )
}