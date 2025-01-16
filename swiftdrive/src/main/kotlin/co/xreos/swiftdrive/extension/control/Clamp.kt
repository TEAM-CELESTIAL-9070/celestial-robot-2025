package co.xreos.swiftdrive.extension.control

import co.xreos.swiftdrive.core.Swiftdrive

val Clamp: Swiftdrive.() -> ClampSettings = {
    ClampSettings()
}

class ClampSettings {
    var min: Double = 0.0
    var max: Double = 0.0
}