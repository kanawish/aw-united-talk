package com.kanastruk.w3c

import kotlinx.serialization.Serializable

/**
 * Representation of W3C Gamepad in Kotlin 'common' space.
 */
@Serializable
class W3CGamepad(
    val axes: List<Double>,
    val buttons: List<W3CGamepadButton>,
    var connected: Boolean,
    var id: String,
    var index: Int,
    var mapping: String /* "" | "standard" */,
    var timestamp: Double
)