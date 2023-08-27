package com.kanastruk.common.model

import kotlinx.coroutines.flow.StateFlow

interface AuthModel {
    val store: StateFlow<AuthState>
    fun anonymousSignIn()
    fun signIn(email: String, password: String)
    fun signOut()
    fun destroy()
}

fun AuthModel.currentUid():String? {
    return (store.value as? AuthState.SignedIn)?.authId
}