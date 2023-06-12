package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    fun onNameInput(names: String){
        state = state.copy(names = names)
    }

    fun onLastNameInput(lastNames: String){
        state = state.copy(lastNames = lastNames)
    }

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    fun onPhoneInput(phone: String){
        state = state.copy(phone = phone)
    }

    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun onConfirmPasswordInput(confirmPassword: String){
        state = state.copy(confirmPassword = confirmPassword)
    }

}