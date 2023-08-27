@file:JsModule("firebase/firestore")
@file:JsNonModule

package com.kanastruk.js.ext.firebase.firestore

import com.kanastruk.js.ext.firebase.DocumentSnapshotObserver
import com.kanastruk.js.ext.firebase.FirebaseApp
import com.kanastruk.js.ext.firebase.QuerySnapshotObserver
import com.kanastruk.js.ext.firebase.db.Query
import kotlin.js.Json
import kotlin.js.Promise

external class Firestore

external interface Query

external interface CollectionReference : Query

external interface DocumentReference {
    val id: String
}

external interface DocumentSnapshot {
    val id: String
    fun data(): Json
    fun exists(): Boolean
}

external interface DocumentChange {
    val doc: DocumentSnapshot
    val type: String
}

external interface QuerySnapshot {
    fun docChanges(): Array<DocumentChange>
}

external fun getFirestore(app: FirebaseApp): Firestore

external fun collection(firestore: Firestore, path: String): CollectionReference

external fun collection(reference: CollectionReference, path: String): CollectionReference

external fun doc(reference: CollectionReference, path: String? = definedExternally): DocumentReference

external fun addDoc(reference: CollectionReference, data: Json): Promise<dynamic>

external fun setDoc(reference: DocumentReference, data: Json): Promise<dynamic>

external fun updateDoc(reference: DocumentReference, data: Json): Promise<dynamic>

external fun getDoc(reference: DocumentReference): Promise<DocumentSnapshot>

external fun onSnapshot(query: Query, observer: QuerySnapshotObserver): () -> Unit

external fun onSnapshot(reference: DocumentReference, observer: DocumentSnapshotObserver): () -> Unit

external interface FirestoreEmulatorOptions {
    var mockUserToken: dynamic /* `T$12`? | `T$13`? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external fun connectFirestoreEmulator(firestore: Firestore, host: String, port: Number, options: FirestoreEmulatorOptions = definedExternally)
