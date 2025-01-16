package co.xreos.swiftdrive.unit.set

import co.xreos.swiftdrive.unit.IUnit

class UnitSet {
    private val units = mutableListOf<IUnit>()

    fun unit(unit: IUnit) {
        units.add(unit)
    }

    fun remove(unit: IUnit) {
        units.remove(unit)
    }
}