package co.xreos.swiftdrive

import co.xreos.swiftdrive.core.Swiftdrive
import co.xreos.swiftdrive.extension.control.BuiltInControl
import co.xreos.swiftdrive.extension.control.Clamp
import co.xreos.swiftdrive.extension.control.PID
import co.xreos.swiftdrive.extension.control.XboxController
import co.xreos.swiftdrive.extension.encoder.ThrustEncoder
import co.xreos.swiftdrive.extension.fieldtracer.FieldTracer
import co.xreos.swiftdrive.layout.RectLayout.Corner.topRight
import co.xreos.swiftdrive.layout.RectLayout.Corner.topLeft
import co.xreos.swiftdrive.layout.RectLayout.Corner.bottomLeft
import co.xreos.swiftdrive.layout.RectLayout.Corner.bottomRight
import co.xreos.swiftdrive.unit.DummyUnit
import kotlin.test.Test
import kotlin.test.todo

@Suppress("UNUSED_VARIABLE")
class SwiftdriveConstructorTest {


    @Test
    fun `Swiftdrive primary constructor must initialize a driveable instance`() {
        val swiftdrive = Swiftdrive {
            name("TestSwiftdrive")

            install(BuiltInControl) {
                input = XboxController(0)
            }
            install(PID.SpeedControl)
            install(Clamp) {
                min = 0.0
                max = 0.8
            }
            install(FieldTracer)
            install(ThrustEncoder)

            rectLayout {
                size(0.8, 0.8)

                place(DummyUnit("1") to topLeft)
                place(DummyUnit("2") to topRight)
                place(DummyUnit("3") to bottomLeft)
                place(DummyUnit("4") to bottomRight)
            }
        }

        TODO()
    }


}