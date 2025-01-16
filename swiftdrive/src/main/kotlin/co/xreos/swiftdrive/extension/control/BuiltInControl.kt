package co.xreos.swiftdrive.extension.control

import co.xreos.swiftdrive.core.Swiftdrive

val BuiltInControl: Swiftdrive.() -> ControlSettings = {
    ControlSettings()
}

class ControlSettings {
    var input: XboxController = XboxController(0)
}

class XboxController(val port: Int) {

}