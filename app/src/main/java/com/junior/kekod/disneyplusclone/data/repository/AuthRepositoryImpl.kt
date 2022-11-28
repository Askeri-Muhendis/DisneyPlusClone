package com.junior.kekod.disneyplusclone.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.junior.kekod.disneyplusclone.domain.common.NetworkResponse
import com.junior.kekod.disneyplusclone.domain.repository.AuthRepository

class AuthRepositoryImpl(
    val auth: FirebaseAuth
): AuthRepository {
    override fun signIn(
        email: String,
        password: String,
        result: (NetworkResponse<String>) -> Unit
    ) {
        result.invoke(NetworkResponse.Loading)
        auth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener { success ->
                result.invoke(NetworkResponse.Success(success.user?.email!!))
            }
            .addOnFailureListener { error ->
                result.invoke(NetworkResponse.Error(error))
            }
    }
}