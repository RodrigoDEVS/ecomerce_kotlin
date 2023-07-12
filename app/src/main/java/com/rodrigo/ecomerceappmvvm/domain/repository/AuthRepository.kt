package com.rodrigo.ecomerceappmvvm.domain.repository

import com.rodrigo.ecomerceappmvvm.domain.model.User
import com.rodrigo.ecomerceappmvvm.domain.util.Response

interface AuthRepository {

    suspend fun login(email: String, password: String): Response<User>

}