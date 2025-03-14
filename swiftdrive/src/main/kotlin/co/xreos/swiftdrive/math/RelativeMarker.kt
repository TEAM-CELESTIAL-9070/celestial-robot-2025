package co.xreos.swiftdrive.math

import kotlin.math.cos
import kotlin.math.sin

@Suppress("MemberVisibilityCanBePrivate")
class RelativeMarker(
    x: Double,
    y: Double,
    val azimuth: Double = 0.0,
): Vector2D(x, y) {
    override fun rotate(angle: Double) = RelativeMarker(
        x * cos(angle) - y * sin(angle),
        x * sin(angle) + y * cos(angle),
        azimuth + angle,
    )
}