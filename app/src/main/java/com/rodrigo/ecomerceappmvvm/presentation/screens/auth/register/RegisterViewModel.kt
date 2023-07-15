package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.register

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigo.ecomerceappmvvm.domain.model.AuthResponse
import com.rodrigo.ecomerceappmvvm.domain.useCase.auth.AuthUseCase
import com.rodrigo.ecomerceappmvvm.domain.util.Request
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(RegisterState())
        private set

    var errorMessage by mutableStateOf("")

    var registerRequest by mutableStateOf<Request<AuthResponse>?>(null)
        private set

    fun register() = viewModelScope.launch{
        if(isValidadForm()){
            registerRequest = Request.Loading
            val result = authUseCase.register(state.email, state.password)
            registerRequest = result
            Log.d("RegisterViewModel", "$registerRequest")
        }
    }

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
    fun isValidadForm(): Boolean {

        if(state.names == ""){
            errorMessage = "Ingrese el nombre"
            return false
        }
        else if(state.lastNames == ""){
            errorMessage = "Ingrese los apellidos"
            return false
        }
        else if(state.email == ""){
            errorMessage = "Ingrese el email"
            return false
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "el email no es válido"
            return false
        }
        else if(state.phone == ""){
            errorMessage = "Ingrese el número telefónico"
            return false
        }
        else if(state.password == ""){
            errorMessage = "Ingrese el password"
            return false
        }
        else if(state.password.length < 6){
            errorMessage = "la contraseña debe tener al menos 6 caracteres"
            return false
        }
        else if(state.confirmPassword == ""){
            errorMessage = "debe confirmar el password"
            return false
        }
        else if(state.password != state.confirmPassword){
            errorMessage = "las contraseñas no coinciden"
            return false
        }
        return true
    }
}