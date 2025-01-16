package co.xreos.swiftdrive.core

import co.xreos.swiftdrive.layout.ILayout
import co.xreos.swiftdrive.unit.IUnit
import co.xreos.swiftdrive.unit.set.UnitSet

class Swiftdrive {
    lateinit var layout: ILayout
    lateinit var name: String
    var unitSet: UnitSet = UnitSet()

    constructor(block: SwiftdriveConfigurer.() -> Unit) {
        val configurer = SwiftdriveConfigurer(this)
        configurer.apply(block)
    }
}