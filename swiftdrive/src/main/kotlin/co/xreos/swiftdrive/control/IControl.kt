package co.xreos.swiftdrive.control

import co.xreos.swiftdrive.math.Vector2D
import java.util.Vector

interface IControl {
    fun calculateDesiredSet(velocity: Vector2D): Vector2D
}