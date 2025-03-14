package co.xreos.swiftdrive.layout

import co.xreos.swiftdrive.math.RelativeMarker
import co.xreos.swiftdrive.unit.IUnit

interface ILayout {
    fun getUnitMarker(unit: IUnit): RelativeMarker
    fun getUnits(): List<IUnit>
}