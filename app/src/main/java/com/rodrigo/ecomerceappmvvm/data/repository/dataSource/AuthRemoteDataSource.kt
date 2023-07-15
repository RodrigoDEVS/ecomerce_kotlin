package com.rodrigo.ecomerceappmvvm.data.repository.dataSource

import com.rodrigo.ecomerceappmvvm.domain.model.AuthResponse
import com.rodrigo.ecomerceappmvvm.domain.model.User
import retrofit2.Response

interface AuthRemoteDataSource {

    suspend fun login(email: String, password: String): Response<AuthResponse>

    suspend fun register(email: String, password: String): Response<AuthResponse>
}