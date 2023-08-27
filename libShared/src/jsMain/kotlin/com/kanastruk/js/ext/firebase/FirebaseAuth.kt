@file:JsModule("firebase/auth")
@file:JsNonModule

package com.kanastruk.js.ext.firebase

import kotlin.js.Promise

// NOTE: I ran dukat against specific entries in the npm package as needed.

// NOTE: manually from platform_node/index.d.ts
external fun getAuth(app: FirebaseApp): Auth

// NOTE: public...

external interface Config {
    var apiKey: String
    var apiHost: String
    var apiScheme: String
    var tokenApiHost: String
    var sdkClientVersion: String
    var authDomain: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface RecaptchaParameters {
    @nativeGetter
    operator fun get(key: String): Any?
    @nativeSetter
    operator fun set(key: String, value: Any)
}

external interface FirebaseTokens {
    var sign_in_provider: String?
        get() = definedExternally
        set(value) = definedExternally
    var sign_in_second_factor: String?
        get() = definedExternally
        set(value) = definedExternally
    var identities: Record<String, String>?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ParsedToken {
    var exp: String?
        get() = definedExternally
        set(value) = definedExternally
    var sub: String?
        get() = definedExternally
        set(value) = definedExternally
    var auth_time: String?
        get() = definedExternally
        set(value) = definedExternally
    var iat: String?
        get() = definedExternally
        set(value) = definedExternally
    var firebase: FirebaseTokens?
        get() = definedExternally
        set(value) = definedExternally
    @nativeGetter
    operator fun get(key: String): dynamic /* String? | Any? */
    @nativeSetter
    operator fun set(key: String, value: String?)
    @nativeSetter
    operator fun set(key: String, value: Any?)
}

external interface AuthErrorData {
    var appName: String
    var email: String?
        get() = definedExternally
        set(value) = definedExternally
    var phoneNumber: String?
        get() = definedExternally
        set(value) = definedExternally
    var tenantId: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface Error {
    var code: String
    var message: String
}

external interface AuthError : Error {
    var customData: AuthErrorData
}

external interface AuthSettings {
    var appVerificationDisabledForTesting: Boolean
}

external interface Auth {
    var app: FirebaseApp
    var name: String
    var config: Config
    fun setPersistence(persistence: Persistence): Promise<Unit>
    var languageCode: String?
    var tenantId: String?
    var settings: AuthSettings
    fun onAuthStateChanged(nextOrObserver: NextFn<User?>, error: ErrorFn = definedExternally, completed: CompleteFn = definedExternally): Unsubscribe
    fun onAuthStateChanged(nextOrObserver: NextFn<User?>): Unsubscribe
    fun onAuthStateChanged(nextOrObserver: NextFn<User?>, error: ErrorFn = definedExternally): Unsubscribe
    fun onAuthStateChanged(nextOrObserver: Observer<User?>, error: ErrorFn = definedExternally, completed: CompleteFn = definedExternally): Unsubscribe
    fun onAuthStateChanged(nextOrObserver: Observer<User?>): Unsubscribe
    fun onAuthStateChanged(nextOrObserver: Observer<User?>, error: ErrorFn = definedExternally): Unsubscribe
    fun beforeAuthStateChanged(callback: (user: User?) -> Any, onAbort: () -> Unit = definedExternally): Unsubscribe
    fun onIdTokenChanged(nextOrObserver: NextFn<User?>, error: ErrorFn = definedExternally, completed: CompleteFn = definedExternally): Unsubscribe
    fun onIdTokenChanged(nextOrObserver: NextFn<User?>): Unsubscribe
    fun onIdTokenChanged(nextOrObserver: NextFn<User?>, error: ErrorFn = definedExternally): Unsubscribe
    fun onIdTokenChanged(nextOrObserver: Observer<User?>, error: ErrorFn = definedExternally, completed: CompleteFn = definedExternally): Unsubscribe
    fun onIdTokenChanged(nextOrObserver: Observer<User?>): Unsubscribe
    fun onIdTokenChanged(nextOrObserver: Observer<User?>, error: ErrorFn = definedExternally): Unsubscribe
    var currentUser: User?
    var emulatorConfig: EmulatorConfig?
    fun updateCurrentUser(user: User?): Promise<Unit>
    fun useDeviceLanguage()
    fun signOut(): Promise<Unit>
}

external interface Persistence {
    var type: String /* "SESSION" | "LOCAL" | "NONE" */
}

external interface IdTokenResult {
    var authTime: String
    var expirationTime: String
    var issuedAtTime: String
    var signInProvider: String?
    var signInSecondFactor: String?
    var token: String
    var claims: ParsedToken
}

external interface ActionCodeInfoData {
    var email: String?
        get() = definedExternally
        set(value) = definedExternally
    var multiFactorInfo: MultiFactorInfo?
        get() = definedExternally
        set(value) = definedExternally
    var previousEmail: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ActionCodeInfo {
    var data: ActionCodeInfoData
    var operation: Any
}

external enum class ActionCodeOperation {
    EMAIL_SIGNIN /* = "EMAIL_SIGNIN" */,
    PASSWORD_RESET /* = "PASSWORD_RESET" */,
    RECOVER_EMAIL /* = "RECOVER_EMAIL" */,
    REVERT_SECOND_FACTOR_ADDITION /* = "REVERT_SECOND_FACTOR_ADDITION" */,
    VERIFY_AND_CHANGE_EMAIL /* = "VERIFY_AND_CHANGE_EMAIL" */,
    VERIFY_EMAIL /* = "VERIFY_EMAIL" */
}

external interface ActionCodeSettingsAndroid {
    var installApp: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var minimumVersion: String?
        get() = definedExternally
        set(value) = definedExternally
    var packageName: String
}

external interface ActionCodeSettingsIOS {
    var bundleId: String
}

external interface ActionCodeSettings {
    var android: ActionCodeSettingsAndroid?
        get() = definedExternally
        set(value) = definedExternally
    var handleCodeInApp: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var iOS: ActionCodeSettingsIOS?
        get() = definedExternally
        set(value) = definedExternally
    var url: String
    var dynamicLinkDomain: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface ApplicationVerifier {
    var type: String
    fun verify(): Promise<String>
}

external interface AuthProvider {
    var providerId: String
}

external enum class FactorId {
    PHONE /* = "phone" */
}

external interface ConfirmationResult {
    var verificationId: String
    fun confirm(verificationCode: String): Promise<UserCredential>
}

external interface MultiFactorAssertion {
    var factorId: Any
}

external interface MultiFactorError : AuthError {
    override var customData: AuthErrorData /* `T$1` & `T$5` */
}

external interface MultiFactorInfo {
    var uid: String
    var displayName: String?
        get() = definedExternally
        set(value) = definedExternally
    var enrollmentTime: String
    var factorId: Any
}

external interface PhoneMultiFactorInfo : MultiFactorInfo {
    var phoneNumber: String
}

external interface MultiFactorResolver {
    var hints: Array<MultiFactorInfo>
    var session: MultiFactorSession
    fun resolveSignIn(assertion: MultiFactorAssertion): Promise<UserCredential>
}

external interface MultiFactorSession

external interface MultiFactorUser {
    var enrolledFactors: Array<MultiFactorInfo>
    fun getSession(): Promise<MultiFactorSession>
    fun enroll(assertion: MultiFactorAssertion, displayName: String? = definedExternally): Promise<Unit>
    fun unenroll(option: MultiFactorInfo): Promise<Unit>
    fun unenroll(option: String): Promise<Unit>
}

external interface PhoneMultiFactorAssertion : MultiFactorAssertion

external interface PhoneSingleFactorInfoOptions {
    var phoneNumber: String
}

external interface PhoneMultiFactorEnrollInfoOptions {
    var phoneNumber: String
    var session: MultiFactorSession
}

external interface PhoneMultiFactorSignInInfoOptions {
    var multiFactorHint: MultiFactorInfo?
        get() = definedExternally
        set(value) = definedExternally
    var multiFactorUid: String?
        get() = definedExternally
        set(value) = definedExternally
    var session: MultiFactorSession
}

external interface ReactNativeAsyncStorage {
    fun setItem(key: String, value: String): Promise<Unit>
    fun getItem(key: String): Promise<String?>
    fun removeItem(key: String): Promise<Unit>
}

external interface User : UserInfo {
    var emailVerified: Boolean
    var isAnonymous: Boolean
    var metadata: UserMetadata
    var providerData: Array<UserInfo>
    var refreshToken: String
    var tenantId: String?
    fun delete(): Promise<Unit>
    fun getIdToken(forceRefresh: Boolean = definedExternally): Promise<String>
    fun getIdTokenResult(forceRefresh: Boolean = definedExternally): Promise<IdTokenResult>
    fun reload(): Promise<Unit>
    fun toJSON(): Any?
}

external interface UserCredential {
    var user: User
    var providerId: String?
    var operationType: Any
}

external interface UserInfo {
    var displayName: String?
    var email: String?
    var phoneNumber: String?
    var photoURL: String?
    var providerId: String
    var uid: String
}

external interface UserMetadata {
    var creationTime: String?
        get() = definedExternally
        set(value) = definedExternally
    var lastSignInTime: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface AdditionalUserInfo {
    var isNewUser: Boolean
    var profile: Record<String, Any>?
    var providerId: String?
    var username: String?
        get() = definedExternally
        set(value) = definedExternally
}

external interface PopupRedirectResolver

external interface EmulatorConfigOptions {
    var disableWarnings: Boolean
}

external interface EmulatorConfig {
    var protocol: String
    var host: String
    var port: Number?
    var options: EmulatorConfigOptions
}

external interface AuthErrorMap

external interface Dependencies {
    var persistence: dynamic /* Persistence? | Array<Persistence>? */
        get() = definedExternally
        set(value) = definedExternally
    var popupRedirectResolver: PopupRedirectResolver?
        get() = definedExternally
        set(value) = definedExternally
    var errorMap: AuthErrorMap?
        get() = definedExternally
        set(value) = definedExternally
}

// NOTE: anonymous.module_@firebase_auth.kt
external fun signInAnonymously(auth: Auth): Promise<UserCredential>

// NOTE: initialize.module_@firebase_auth.kt
external fun initializeAuth(app: FirebaseApp, deps: Dependencies = definedExternally): Auth

// NOTE: reload.module_@firebase_auth.kt
external fun reload(user: User): Promise<Unit>

// NOTE: email_and_password.module_@firebase_auth.kt

external fun sendPasswordResetEmail(auth: Auth, email: String, actionCodeSettings: ActionCodeSettings = definedExternally): Promise<Unit>

external fun confirmPasswordReset(auth: Auth, oobCode: String, newPassword: String): Promise<Unit>

external fun connectAuthEmulator(auth: Auth, url: String, options: EmulatorConfigOptions = definedExternally)

external fun applyActionCode(auth: Auth, oobCode: String): Promise<Unit>

external fun checkActionCode(auth: Auth, oobCode: String): Promise<ActionCodeInfo>

external fun verifyPasswordResetCode(auth: Auth, code: String): Promise<String>

external fun createUserWithEmailAndPassword(auth: Auth, email: String, password: String): Promise<UserCredential>

external fun signInWithEmailAndPassword(auth: Auth, email: String, password: String): Promise<UserCredential>

// NOTE: Selections from auth.module_@firebase_auth.kt

external fun signInWithPopup(auth: Auth, provider: AuthProvider, resolver: PopupRedirectResolver = definedExternally): Promise<UserCredential>

external fun signInWithRedirect(auth: Auth, provider: AuthProvider, resolver: PopupRedirectResolver = definedExternally): Promise<Any>

external fun signOut(auth: Auth): Promise<Unit>

