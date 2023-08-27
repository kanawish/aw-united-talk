package com.kanastruk.js.ext.firebase

import com.kanastruk.js.ext.firebase.firestore.QuerySnapshot

data class QuerySnapshotObserver(
    @JsName("next")
    val next: (QuerySnapshot) -> Unit,
    @JsName("error")
    val error: (Throwable) -> Unit,
    @JsName("complete")
    val complete: () -> Unit,
)