package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register

data class RegisterState(
    val names: String = "",
    val lastNames: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val confirmPassword: String = ""
)
