package com.kanastruk.mvi.intent

import kotlinx.coroutines.flow.MutableStateFlow

operator fun <T> MutableStateFlow<T>.plusAssign(intent:Intent<T>) {
    value = intent.reduce(value)
}

