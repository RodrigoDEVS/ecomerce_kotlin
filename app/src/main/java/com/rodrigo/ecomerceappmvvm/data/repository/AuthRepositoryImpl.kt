package com.rodrigo.ecomerceappmvvm.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.rodrigo.ecomerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.rodrigo.ecomerceappmvvm.domain.model.User
import com.rodrigo.ecomerceappmvvm.domain.repository.AuthRepository
import com.rodrigo.ecomerceappmvvm.domain.util.Response
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String, password: String): Response<User> {
        return try {
            val auth = FirebaseAuth.getInstance()
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val firebaseUser: FirebaseUser? = result.user
            if (firebaseUser != null) {
                val user = User(firebaseUser.uid, firebaseUser.email)
                Response.Success(user)
            } else {
                Response.Failure(Exception("El inicio de sesión fue exitoso, pero no se pudo obtener el usuario."))
            }
        }catch (e: Exception){
            e.printStackTrace()
            Response.Failure(e)
        }
    }
}