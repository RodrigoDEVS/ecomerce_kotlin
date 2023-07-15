package com.rodrigo.ecomerceappmvvm.domain.repository

import com.rodrigo.ecomerceappmvvm.domain.model.AuthResponse
import com.rodrigo.ecomerceappmvvm.domain.model.User
import com.rodrigo.ecomerceappmvvm.domain.util.Request

interface AuthRepository {

    suspend fun login(email: String, password: String): Request<AuthResponse>

    suspend fun register(email: String, password: String): Request<AuthResponse>

}