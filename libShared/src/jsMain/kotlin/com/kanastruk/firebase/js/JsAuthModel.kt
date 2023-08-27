package com.kanastruk.firebase.js

import com.kanastruk.common.model.AuthModel
import com.kanastruk.common.model.AuthState
import com.kanastruk.js.ext.firebase.Auth
import com.kanastruk.js.ext.firebase.FirebaseApp
import com.kanastruk.js.ext.firebase.User
import com.kanastruk.js.ext.firebase.connectAuthEmulator
import com.kanastruk.js.ext.firebase.getAuth
import com.kanastruk.js.ext.firebase.signInAnonymously
import com.kanastruk.js.ext.firebase.signInWithEmailAndPassword
import com.kanastruk.utils.SearchParamHelper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JsAuthModel(
    private val app: FirebaseApp,
    scope: CoroutineScope
): CoroutineScope by scope, AuthModel {
    private val auth: Auth by lazy {
        getAuth(app).also { a ->
            if (SearchParamHelper.isEmulator()) {
                connectAuthEmulator(a, "http://localhost:9099")
            }
        }
    }

    private val _store = MutableStateFlow<AuthState>(AuthState.Loading)
    override val store: StateFlow<AuthState> = _store.asStateFlow()

    // Consider exposing this in `SignedIn`.
    fun currentUser(): User? = auth.currentUser

    init {
        println("🔥 init")
        auth.onAuthStateChanged { currentUser ->
            println("🔥 AuthStateListener : $currentUser")
            _store.value = when(currentUser) {
                null -> {
                    println("🔥 Signed Out")
                    AuthState.SignedOut
                }
                else -> {
                    println("🔥 Signed In $auth")
                    currentUser.uid.let(AuthState::SignedIn)
                }
            }
        }

        // Internal logger for auth states, but also auto-sign in (for now)
        launch {
            _store.collect { authState ->
                println("🔥 authState: $authState")
                when(authState) {
                    AuthState.Loading -> println("🔥 Loading")
                    AuthState.SignedOut -> println("🔥 SignedOut")
                    is AuthState.SignedIn -> println("🔥 Signed In")
                    else -> { TODO("Add error handling here, ...")}
                }
            }
        }
    }

    override fun anonymousSignIn() {
        signInAnonymously(auth)
    }

    override fun signIn(email: String, password: String) {
        signInWithEmailAndPassword(auth, email, password)
    }

    override fun signOut() {
        com.kanastruk.js.ext.firebase.signOut(auth)
    }

    override fun destroy() {
        // TODO: Investigate clearing of listeners with JS...
        //   and potential use of `promise.await()` above.
        cancel()
    }

}