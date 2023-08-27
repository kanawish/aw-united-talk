@file:JsModule("firebase/database")
@file:JsNonModule

package com.kanastruk.js.ext.firebase.db

import com.kanastruk.js.ext.firebase.FirebaseApp
import com.kanastruk.js.ext.firebase.firestore.Query
import com.kanastruk.js.ext.firebase.Unsubscribe
import kotlin.js.*
import kotlin.Error

external fun child(parent: DatabaseReference, path: String): DatabaseReference

external interface `T$0` {
    var mockUserToken: dynamic /* `T$4`? | `T$5`? | String? */
        get() = definedExternally
        set(value) = definedExternally
}

external fun connectDatabaseEmulator(db: Database, host: String, port: Number, options: `T$0` = definedExternally)

external open class Database {
    open var app: FirebaseApp
    // open var type: Any = "database"
}

external interface DatabaseReference : Query {
    var key: String?
    var parent: DatabaseReference?
    var root: DatabaseReference
}

external open class DataSnapshot {
    open var ref: DatabaseReference
    open fun child(path: String): DataSnapshot
    open fun exists(): Boolean
    open fun exportVal(): Any
    open fun forEach(action: (child: DataSnapshot) -> Any): Boolean
    open fun hasChild(path: String): Boolean
    open fun hasChildren(): Boolean
    open fun toJSON(): Any?
    open fun `val`(): Any
}

external fun enableLogging(enabled: Boolean, persistent: Boolean = definedExternally): Any

external fun enableLogging(enabled: Boolean): Any

external fun enableLogging(logger: (message: String) -> Any): Any

external fun endAt(value: Number?, key: String = definedExternally): QueryConstraint

external fun endAt(value: Number?): QueryConstraint

external fun endAt(value: String?, key: String = definedExternally): QueryConstraint

external fun endAt(value: String?): QueryConstraint

external fun endAt(value: Boolean?, key: String = definedExternally): QueryConstraint

external fun endAt(value: Boolean?): QueryConstraint

external fun endBefore(value: Number?, key: String = definedExternally): QueryConstraint

external fun endBefore(value: Number?): QueryConstraint

external fun endBefore(value: String?, key: String = definedExternally): QueryConstraint

external fun endBefore(value: String?): QueryConstraint

external fun endBefore(value: Boolean?, key: String = definedExternally): QueryConstraint

external fun endBefore(value: Boolean?): QueryConstraint

external fun equalTo(value: Number?, key: String = definedExternally): QueryConstraint

external fun equalTo(value: Number?): QueryConstraint

external fun equalTo(value: String?, key: String = definedExternally): QueryConstraint

external fun equalTo(value: String?): QueryConstraint

external fun equalTo(value: Boolean?, key: String = definedExternally): QueryConstraint

external fun equalTo(value: Boolean?): QueryConstraint

external fun forceLongPolling()

external fun forceWebSockets()

external fun get(query: Query): Promise<DataSnapshot>

external fun getDatabase(app: FirebaseApp = definedExternally, url: String = definedExternally): Database

external fun goOffline(db: Database)

external fun goOnline(db: Database)

external fun increment(delta: Number): Any?

external fun limitToFirst(limit: Number): QueryConstraint

external fun limitToLast(limit: Number): QueryConstraint

external interface ListenOptions {
    var onlyOnce: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external fun off(query: Query, eventType: String /* "value" | "child_added" | "child_changed" | "child_moved" | "child_removed" */ = definedExternally, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any = definedExternally)

external fun onChildAdded(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any, cancelCallback: (error: Error) -> Any = definedExternally): Unsubscribe

external fun onChildAdded(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any): Unsubscribe

external fun onChildAdded(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any, options: ListenOptions): Unsubscribe

external fun onChildAdded(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any, cancelCallback: (error: Error) -> Any, options: ListenOptions): Unsubscribe

external fun onChildChanged(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any, cancelCallback: (error: Error) -> Any = definedExternally): Unsubscribe

external fun onChildChanged(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any): Unsubscribe

external fun onChildChanged(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any, options: ListenOptions): Unsubscribe

external fun onChildChanged(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any, cancelCallback: (error: Error) -> Any, options: ListenOptions): Unsubscribe

external fun onChildMoved(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any, cancelCallback: (error: Error) -> Any = definedExternally): Unsubscribe

external fun onChildMoved(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any): Unsubscribe

external fun onChildMoved(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any, options: ListenOptions): Unsubscribe

external fun onChildMoved(query: Query, callback: (snapshot: DataSnapshot, previousChildName: String?) -> Any, cancelCallback: (error: Error) -> Any, options: ListenOptions): Unsubscribe

external fun onChildRemoved(query: Query, callback: (snapshot: DataSnapshot) -> Any, cancelCallback: (error: Error) -> Any = definedExternally): Unsubscribe

external fun onChildRemoved(query: Query, callback: (snapshot: DataSnapshot) -> Any): Unsubscribe

external fun onChildRemoved(query: Query, callback: (snapshot: DataSnapshot) -> Any, options: ListenOptions): Unsubscribe

external fun onChildRemoved(query: Query, callback: (snapshot: DataSnapshot) -> Any, cancelCallback: (error: Error) -> Any, options: ListenOptions): Unsubscribe

external open class OnDisconnect {
    open fun cancel(): Promise<Unit>
    open fun remove(): Promise<Unit>
    open fun set(value: Any): Promise<Unit>
    open fun setWithPriority(value: Any, priority: Number?): Promise<Unit>
    open fun setWithPriority(value: Any, priority: String?): Promise<Unit>
    open fun update(values: Any?): Promise<Unit>
}

external fun onDisconnect(ref: DatabaseReference): OnDisconnect

external fun onValue(query: Query, callback: (snapshot: DataSnapshot) -> Any, cancelCallback: (error: Error) -> Any = definedExternally): Unsubscribe

external fun onValue(query: Query, callback: (snapshot: DataSnapshot) -> Any): Unsubscribe

external fun onValue(query: Query, callback: (snapshot: DataSnapshot) -> Any, options: ListenOptions): Unsubscribe

external fun onValue(query: Query, callback: (snapshot: DataSnapshot) -> Any, cancelCallback: (error: Error) -> Any, options: ListenOptions): Unsubscribe

external fun orderByChild(path: String): QueryConstraint

external fun orderByKey(): QueryConstraint

external fun orderByPriority(): QueryConstraint

external fun orderByValue(): QueryConstraint

external fun push(parent: DatabaseReference, value: Any = definedExternally): ThenableReference

external interface Query {
    var ref: DatabaseReference
    fun isEqual(other: Query?): Boolean
    fun toJSON(): String
    override fun toString(): String
}

external fun query(query: Query, vararg queryConstraints: QueryConstraint): Query

external open class QueryConstraint {
    open var type: String /* "endAt" | "endBefore" | "startAt" | "startAfter" | "limitToFirst" | "limitToLast" | "orderByChild" | "orderByKey" | "orderByPriority" | "orderByValue" | "equalTo" */
}

external fun ref(db: Database, path: String = definedExternally): DatabaseReference

external fun refFromURL(db: Database, url: String): DatabaseReference

external fun remove(ref: DatabaseReference): Promise<Unit>

external fun runTransaction(ref: DatabaseReference, transactionUpdate: (currentData: Any) -> Any, options: TransactionOptions = definedExternally): Promise<TransactionResult>

external fun serverTimestamp(): Any

external fun set(ref: DatabaseReference, value: Any): Promise<Unit>

external fun setPriority(ref: DatabaseReference, priority: String?): Promise<Unit>

external fun setPriority(ref: DatabaseReference, priority: Number?): Promise<Unit>

external fun setWithPriority(ref: DatabaseReference, value: Any, priority: String?): Promise<Unit>

external fun setWithPriority(ref: DatabaseReference, value: Any, priority: Number?): Promise<Unit>

external fun startAfter(value: Number?, key: String = definedExternally): QueryConstraint

external fun startAfter(value: Number?): QueryConstraint

external fun startAfter(value: String?, key: String = definedExternally): QueryConstraint

external fun startAfter(value: String?): QueryConstraint

external fun startAfter(value: Boolean?, key: String = definedExternally): QueryConstraint

external fun startAfter(value: Boolean?): QueryConstraint

external fun startAt(value: Number? = definedExternally, key: String = definedExternally): QueryConstraint

external fun startAt(): QueryConstraint

external fun startAt(value: Number? = definedExternally): QueryConstraint

external fun startAt(value: String? = definedExternally, key: String = definedExternally): QueryConstraint

external fun startAt(value: String? = definedExternally): QueryConstraint

external fun startAt(value: Boolean? = definedExternally, key: String = definedExternally): QueryConstraint

external fun startAt(value: Boolean? = definedExternally): QueryConstraint

external interface ThenableReference : DatabaseReference//, Pick<Promise<DatabaseReference>, String /* "then" | "catch" */>

external interface TransactionOptions {
    var applyLocally: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

external open class TransactionResult {
    open var committed: Boolean
    open var snapshot: DataSnapshot
    open fun toJSON(): Any?
}

external fun update(ref: DatabaseReference, values: Any?): Promise<Unit>