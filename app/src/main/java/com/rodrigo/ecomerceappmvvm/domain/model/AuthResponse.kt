package com.rodrigo.ecomerceappmvvm.domain.model

import com.google.gson.Gson

data class AuthResponse (
    val user: User? = null,
    val token: String? = null
) {
    public fun toJson() = Gson().toJson(this)

    companion object {
        public fun fromJson(json: String) = Gson().fromJson(json, AuthResponse::class.java)
    }
}

