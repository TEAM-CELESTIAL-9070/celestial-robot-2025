package co.xreos.swiftdrive.layout

import co.xreos.swiftdrive.type.math.RelativeMarker
import co.xreos.swiftdrive.unit.IUnit
import kotlin.math.atan2

val topLeft = RectLayout.Corner.topLeft
val topRight = RectLayout.Corner.topRight
val bottomLeft = RectLayout.Corner.bottomLeft
val bottomRight = RectLayout.Corner.bottomRight

class RectLayout: ILayout {
    private var width: Double = 0.0
    private var height: Double = 0.0

    private var topLeftUnit: IUnit? = null
    private var topRightUnit: IUnit? = null
    private var bottomLeftUnit: IUnit? = null
    private var bottomRightUnit: IUnit? = null
    private var diagonal: Boolean = false


    fun size(width: Double, height: Double) {
        this.width = width
        this.height = height
    }

    fun topLeft(unit: IUnit) {
        topLeftUnit = unit
    }

    fun topRight(unit: IUnit) {
        topRightUnit = unit
    }

    fun bottomLeft(unit: IUnit) {
        bottomLeftUnit = unit
    }

    fun bottomRight(unit: IUnit) {
        bottomRightUnit = unit
    }

    fun diagonal(value: Boolean = true) {
        diagonal = value
    }

    fun place(pair: Pair<IUnit, Corner>) {
        when (pair.second) {
            Corner.topLeft -> topLeft(pair.first)
            Corner.topRight -> topRight(pair.first)
            Corner.bottomLeft -> bottomLeft(pair.first)
            Corner.bottomRight -> bottomRight(pair.first)
        }
    }

    override fun getUnitMarker(unit: IUnit): RelativeMarker {
        val x = when (unit) {
            topLeftUnit -> -width / 2
            topRightUnit -> width / 2
            bottomLeftUnit -> -width / 2
            bottomRightUnit -> width / 2
            else -> throw IllegalArgumentException("Unit '$unit' does not exist in the layout")
        }
        val y = when (unit) {
            topLeftUnit -> height / 2
            topRightUnit ->  height / 2
            bottomLeftUnit ->  -height / 2
            bottomRightUnit -> -height / 2
            else -> throw IllegalArgumentException("Unit '$unit' does not exist in the layout")
        }
        return RelativeMarker(x, y, if(diagonal) atan2(y, x) else 0.0)
    }

    enum class Corner {
        topLeft,
        topRight,
        bottomLeft,
        bottomRight,
    }
}