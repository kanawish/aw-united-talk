package com.kanastruk.js.ext.dom

import org.khronos.webgl.Float32Array
import kotlin.js.Promise

/**
 * NOTE: I'm assuming force-casting navigator to this interface type
 *   will help me achieve what I'm looking for.
 */
external interface NavigatorExtras {
    fun getGamepads(): Array<Gamepad?>
}

external interface GamepadEventInit : EventInit {
    var gamepad: Gamepad
}

external interface EventInit {
    var bubbles: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var cancelable: Boolean?
        get() = definedExternally
        set(value) = definedExternally
    var composed: Boolean?
        get() = definedExternally
        set(value) = definedExternally
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface Gamepad {
    val axes: Array<Number>
    val buttons: Array<GamepadButton>
    var connected: Boolean
    var hand: String /* "" | "left" | "right" */
    var hapticActuators: Array<GamepadHapticActuator>
    var id: String
    var index: Number
    var mapping: String /* "" | "standard" */
    var pose: GamepadPose?
    var timestamp: Number

    companion object {
        var prototype: Gamepad
    }
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface GamepadButton {
    var pressed: Boolean
    var touched: Boolean
    var value: Number

    companion object {
        var prototype: GamepadButton
    }
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface GamepadHapticActuator {
    var type: String /* "vibration" */
    fun pulse(value: Number, duration: Number): Promise<Boolean>

    companion object {
        var prototype: GamepadHapticActuator
    }
}

@Suppress("NESTED_CLASS_IN_EXTERNAL_INTERFACE")
external interface GamepadPose {
    var angularAcceleration: Float32Array?
    var angularVelocity: Float32Array?
    var hasOrientation: Boolean
    var hasPosition: Boolean
    var linearAcceleration: Float32Array?
    var linearVelocity: Float32Array?
    var orientation: Float32Array?
    var position: Float32Array?

    companion object {
        var prototype: GamepadPose
    }
}
