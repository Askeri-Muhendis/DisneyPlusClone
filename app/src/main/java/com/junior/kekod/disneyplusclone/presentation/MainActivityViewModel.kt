package com.junior.kekod.disneyplusclone.presentation

import androidx.lifecycle.ViewModel
import com.junior.kekod.disneyplusclone.domain.common.NetworkResponse
import com.junior.kekod.disneyplusclone.domain.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {

    fun signInMember(email: String, password: String) {
        repository.signIn(email, password) { result ->
            when (result) {
                is NetworkResponse.Success -> {
                    println("Success")
                }
                is NetworkResponse.Error -> {
                    println("Error")
                }
                is NetworkResponse.Loading -> {
                    println("Loading")
                }
            }
        }
    }
}