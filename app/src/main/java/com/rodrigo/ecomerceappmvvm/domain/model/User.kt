package com.rodrigo.ecomerceappmvvm.domain.model

import com.google.gson.Gson

data class User(
    val email: String? = null,
    val password: String? = null,
    var returnSecureToken: Boolean? = true
){
    fun toJson(): String = Gson().toJson(this)

    companion object{
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}
