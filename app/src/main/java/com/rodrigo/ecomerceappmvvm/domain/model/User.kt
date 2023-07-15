package com.rodrigo.ecomerceappmvvm.domain.model

import android.net.Uri
import com.google.gson.Gson

data class User(
    val email: String? = null,
    val uid: String? = null,
    val displayName: String? = null,
    val phoneNumber: String? = null,
    val isEmailVerified: Boolean? = null,
    val photoUrl: Uri? = null
){
    fun toJson(): String = Gson().toJson(this)

    companion object{
        fun fromJson(data: String): User = Gson().fromJson(data, User::class.java)
    }
}
