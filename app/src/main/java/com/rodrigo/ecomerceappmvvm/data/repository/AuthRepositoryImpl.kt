package com.rodrigo.ecomerceappmvvm.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.rodrigo.ecomerceappmvvm.data.repository.dataSource.AuthRemoteDataSource
import com.rodrigo.ecomerceappmvvm.domain.model.AuthResponse
import com.rodrigo.ecomerceappmvvm.domain.model.User
import com.rodrigo.ecomerceappmvvm.domain.repository.AuthRepository
import com.rodrigo.ecomerceappmvvm.domain.util.Request
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl(private val authRemoteDataSource: AuthRemoteDataSource): AuthRepository {
    override suspend fun login(email: String, password: String): Request<AuthResponse> {
        return try {
            val auth = FirebaseAuth.getInstance()
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val firebaseUser: FirebaseUser? = result.user
            val token = firebaseUser?.getIdToken(false)?.result?.token

            if (firebaseUser != null) {
                val user = User(
                    firebaseUser.email,
                    firebaseUser.uid,
                    firebaseUser.displayName,
                    firebaseUser.phoneNumber,
                    firebaseUser.isEmailVerified,
                    firebaseUser.photoUrl)
                val response = AuthResponse(user, token)
                Request.Success(response)
            } else {
                Request.Failure(Exception("El inicio de sesión fue exitoso, pero no se pudo obtener el usuario."))
            }
        }catch (e: Exception){
            e.printStackTrace()
            Request.Failure(e)
        }
    }

    override suspend fun register(email: String, password: String): Request<AuthResponse> {
        return try {
            val auth = FirebaseAuth.getInstance()
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val firebaseUser: FirebaseUser? = result.user
            val token = firebaseUser?.getIdToken(false)?.result?.token

            if (firebaseUser != null) {
                val user = User(
                    firebaseUser.email,
                    firebaseUser.uid,
                    firebaseUser.displayName,
                    firebaseUser.phoneNumber,
                    firebaseUser.isEmailVerified,
                    firebaseUser.photoUrl)
                val response = AuthResponse(user, token)
                Request.Success(response)
            } else {
                Request.Failure(Exception("El registro de usuario fue exitoso, pero no se pudo obtener el usuario."))
            }
        }catch (e: Exception){
            e.printStackTrace()
            Request.Failure(e)
        }
    }
}