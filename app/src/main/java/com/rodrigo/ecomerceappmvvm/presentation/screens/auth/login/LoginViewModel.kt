package com.rodrigo.ecomerceappmvvm.presentation.screens.auth.login

import android.util.Log
import android.util.Patterns
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigo.ecomerceappmvvm.domain.model.AuthResponse
import com.rodrigo.ecomerceappmvvm.domain.util.Request
import com.rodrigo.ecomerceappmvvm.domain.useCase.auth.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    var errorMessage by mutableStateOf("")

    var loginRequest by mutableStateOf<Request<AuthResponse>?>(null)
        private set

    fun login() = viewModelScope.launch {
        if(isValidForm()){
            loginRequest = Request.Loading
            val result = authUseCase.login(state.email, state.password)
            loginRequest = result
            Log.d("LoginViewModel", "Response: $loginRequest")
        }
    }

    fun onEmailInput(email: String){
        state = state.copy(email = email)
    }

    fun onPasswordInput(password: String){
        state = state.copy(password = password)
    }

    fun isValidForm(): Boolean {
        if(!Patterns.EMAIL_ADDRESS.matcher(state.email).matches()){
            errorMessage = "el email no es válido"
            return false
        }
        else if(state.password.length < 6){
            errorMessage = "la contraseña debe tener al menos 6 caracteres"
            return false
        }
        return true
    }
}