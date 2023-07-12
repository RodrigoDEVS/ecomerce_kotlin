package com.rodrigo.ecomerceappmvvm.domain.useCase.auth

import com.rodrigo.ecomerceappmvvm.domain.repository.AuthRepository

class LoginUseCase(private val authRepository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = authRepository.login(email, password)

}