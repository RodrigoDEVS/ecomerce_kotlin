package com.rodrigo.ecomerceappmvvm.domain.useCase.auth

data class AuthUseCase(
    val login: LoginUseCase,
    val register: RegisterUseCase
)
