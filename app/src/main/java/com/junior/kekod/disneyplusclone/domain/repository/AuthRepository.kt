package com.junior.kekod.disneyplusclone.domain.repository

import com.junior.kekod.disneyplusclone.domain.common.NetworkResponse

interface AuthRepository {

    fun signIn(email: String, password: String, result: (NetworkResponse<String>) -> Unit)
}