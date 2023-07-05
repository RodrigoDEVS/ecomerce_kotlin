package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register

import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")
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
    fun validateForm() = viewModelScope.launch {

        if(state.names == ""){
            errorMessage = "Ingrese el nombre"
        }
        else if(state.lastNames == ""){
            errorMessage = "Ingrese los apellidos"
        }
        else if(state.email == ""){
            errorMessage = "Ingrese el email"
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "el email no es válido"
        }
        else if(state.phone == ""){
            errorMessage = "Ingrese el número telefónico"
        }
        else if(state.password == ""){
            errorMessage = "Ingrese el password"
        }
        else if(state.password.length < 6){
            errorMessage = "la contraseña debe tener al menos 6 caracteres"
        }
        else if(state.confirmPassword == ""){
            errorMessage = "debe confirmar el password"
        }
        else if(state.password != state.confirmPassword){
            errorMessage = "las contraseñas no coinciden"
        }


        delay(3000)

        errorMessage = ""
    }
}