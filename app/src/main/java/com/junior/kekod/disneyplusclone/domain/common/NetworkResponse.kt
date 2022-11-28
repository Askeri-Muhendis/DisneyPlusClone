package com.junior.kekod.disneyplusclone.domain.common

sealed class NetworkResponse<out T> {
    data class Success<out T>(val data: T): NetworkResponse<T>()
    data class Error(val error: Exception): NetworkResponse<Nothing>()
    object Loading: NetworkResponse<Nothing>()
}
