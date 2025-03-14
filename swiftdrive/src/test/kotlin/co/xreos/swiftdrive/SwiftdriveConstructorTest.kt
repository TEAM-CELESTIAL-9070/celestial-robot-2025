package co.xreos.swiftdrive

import co.xreos.swiftdrive.core.Swiftdrive
import co.xreos.swiftdrive.extension.control.Clamp
import co.xreos.swiftdrive.extension.encoder.ThrustEncoder
import co.xreos.swiftdrive.extension.fieldtracer.FieldTracer
import co.xreos.swiftdrive.layout.RectLayout.Corner.*
import co.xreos.swiftdrive.unit.DummyUnit
import kotlin.test.Test

@Suppress("UNUSED_VARIABLE")
class SwiftdriveConstructorTest {


    @Test
    fun `Swiftdrive primary constructor must initialize a driveable instance`() {
        val swiftdrive = Swiftdrive {
            name("TestSwiftdrive")

            rectLayout {
                size(0.8, 0.8)

                place(DummyUnit("1") to TopLeft)
                place(DummyUnit("2") to TopRight)
                place(DummyUnit("3") to BottomLeft)
                place(DummyUnit("4") to BottomRight)
            }

            install(FieldTracer)
            install(ThrustEncoder)
            install(Clamp) {
                min = 0.0
                max = 1.0
            }
        }
    }


}