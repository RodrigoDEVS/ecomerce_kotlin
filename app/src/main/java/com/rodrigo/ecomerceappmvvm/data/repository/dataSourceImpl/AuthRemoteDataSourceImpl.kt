package com.rodrigo.ecomerceappmvvm.data.repository.dataSourceImpl

import com.rodrigo.ecomerceappmvvm.data.api.AuthService
import com.rodrigo.ecomerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.rodrigo.ecomerceappmvvm.domain.model.AuthResponse
import com.rodrigo.ecomerceappmvvm.domain.model.User
import retrofit2.Response

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

    override suspend fun login(email: String, password: String) = authService.login(email, password)
    override suspend fun register(email: String, password: String): Response<AuthResponse> = authService.register(email, password)
}