package com.kanastruk.common.model

sealed class AuthState {
    object Loading : AuthState()
    object SignedOut : AuthState()
    data class SignedIn(val authId: String) : AuthState()
    data class AuthError(val msg: String) : AuthState()
}
