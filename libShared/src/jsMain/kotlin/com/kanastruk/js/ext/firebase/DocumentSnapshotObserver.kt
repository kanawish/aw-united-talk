package com.kanastruk.js.ext.firebase

import com.kanastruk.js.ext.firebase.firestore.DocumentSnapshot

data class DocumentSnapshotObserver(
    @JsName("next")
    val next: (DocumentSnapshot) -> Unit,
    @JsName("error")
    val error: (Throwable) -> Unit,
    @JsName("complete")
    val complete: () -> Unit,
)
