package co.xreos.swiftdrive.math

import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt

open class Vector2D(
    val x: Double,
    val y: Double,
) {
    open operator fun plus(other: Vector2D) = Vector2D(x + other.x, y + other.y)
    open operator fun minus(other: Vector2D) = Vector2D(x - other.x, y - other.y)
    open operator fun times(scalar: Double) = Vector2D(x * scalar, y * scalar)
    open operator fun div(scalar: Double) = Vector2D(x / scalar, y / scalar)
    open operator fun unaryMinus() = Vector2D(-x, -y)

    open fun dot(other: Vector2D) = x * other.x + y * other.y
    open fun cross(other: Vector2D) = x * other.y - y * other.x
    open fun magnitude() = sqrt(x * x + y * y)
    open fun normalize() = this / magnitude()
    open fun rotate(angle: Double) = Vector2D(
        x * cos(angle) - y * sin(angle),
        x * sin(angle) + y * cos(angle),
    )
}