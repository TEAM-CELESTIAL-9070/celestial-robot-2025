package co.xreos.swiftdrive.layout

import co.xreos.swiftdrive.math.RelativeMarker
import co.xreos.swiftdrive.unit.IUnit

class LayoutImpl(units: Map<IUnit, RelativeMarker>): ILayout {
    private val units: MutableMap<IUnit, RelativeMarker> = units.toMutableMap()

    fun place(block: MutableMap<IUnit, RelativeMarker>.() -> Unit) {
        units.apply(block)
    }

    fun place(unit: IUnit, relativeMarker: RelativeMarker) {
        units[unit] = relativeMarker
    }

    fun place(pair: Pair<IUnit, RelativeMarker>) {
        place(pair.first, pair.second)
    }

    fun place(unit: IUnit, x: Double, y: Double, azimuth: Double = 0.0) {
        place(unit, RelativeMarker(x, y, azimuth))
    }

    override fun getUnitMarker(unit: IUnit): RelativeMarker {
        return units[unit] ?: throw IllegalArgumentException("Unit '$unit' does not exist in the layout")
    }

    override fun getUnits(): List<IUnit> {
        return units.keys.toList()
    }
}