package com.kanastruk.utils

import kotlin.js.Json

fun Json.string(prop: String, fallback:String=""): String = this[prop] as? String ?: fallback
fun Json.stringN(prop: String): String? = this[prop] as? String
fun Json.boolean(prop: String, fallback:Boolean=false): Boolean = this[prop] as? Boolean ?: fallback
fun Json.booleanN(prop: String): Boolean? = this[prop] as? Boolean
fun Json.int(prop: String, fallback:Int=0): Int = this[prop] as? Int ?: fallback
fun Json.intN(prop: String): Int? = this[prop] as? Int
fun Json.double(prop: String, fallback:Double=0.0): Double = this[prop] as? Double ?: fallback
fun Json.doubleN(prop: String): Double? = this[prop] as? Double