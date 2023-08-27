package com.kanastruk.w3c

import kotlinx.serialization.Serializable

/**
 * Representation of W3C GamepadButton in Kotlin 'common' space.
 */
@Serializable
class W3CGamepadButton (
    var pressed: Boolean,
    var touched: Boolean,
    var value: Double
)
