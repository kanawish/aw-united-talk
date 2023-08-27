package com.kanastruk.js

import com.kanastruk.js.ext.dom.Gamepad
import com.kanastruk.js.ext.dom.GamepadButton
import kotlin.math.abs

fun Gamepad.toW3CGamepad() = com.kanastruk.w3c.W3CGamepad(
    axes = axes.map { it.toDouble() },
    buttons = buttons.map { it.toW3CGamepadButton() },
    connected = connected,
    id = id,
    index = index.toInt(),
    mapping = mapping,
    timestamp = timestamp.toDouble()
)

fun GamepadButton.toW3CGamepadButton() = com.kanastruk.w3c.W3CGamepadButton(pressed, touched, value.toDouble())
