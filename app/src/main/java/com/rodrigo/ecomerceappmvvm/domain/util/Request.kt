package com.rodrigo.ecomerceappmvvm.domain.util

sealed class Request<out T>{
    object Loading: Request<Nothing>()
    data class Success<out T>(val data: T): Request<T>()
    data class Failure<out T>(val exception: Exception): Request<T>()
}
