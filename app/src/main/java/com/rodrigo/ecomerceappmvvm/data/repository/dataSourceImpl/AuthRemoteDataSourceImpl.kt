package com.rodrigo.ecomerceappmvvm.data.repository.dataSourceImpl

import com.rodrigo.ecomerceappmvvm.data.api.AuthService
import com.rodrigo.ecomerceappmvvm.data.repository.dataSource.AuthRemoteDataSource

class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

    override suspend fun login(email: String, password: String) = authService.login(email, password)
}