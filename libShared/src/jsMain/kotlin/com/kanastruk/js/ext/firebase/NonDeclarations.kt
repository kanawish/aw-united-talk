package com.kanastruk.js.ext.firebase

// typealias Persistence = String

typealias Record<K, T> = Any
typealias UserProfile = Record<String, Any>

typealias Operation = String

typealias CompleteFn = () -> Unit

typealias ErrorFn = (error: Error) -> Unit

typealias FirebaseError = Error

typealias NextFn<T> = (value: T) -> Unit

external interface Observer<T> {
    var next: NextFn<T>
    var error: ErrorFn
    var complete: CompleteFn
}

typealias Unsubscribe = () -> Unit