package co.xreos.swiftdrive.core

import co.xreos.swiftdrive.layout.LayoutImpl
import co.xreos.swiftdrive.layout.RectLayout
import co.xreos.swiftdrive.unit.IUnit
import co.xreos.swiftdrive.unit.set.UnitSet

class SwiftdriveConfigurer(private val swiftdrive: Swiftdrive) {
    fun layout(block: LayoutImpl.() -> Unit) {
        val layout = LayoutImpl(emptyMap())
        layout.apply(block)
    }

    fun rectLayout(block: RectLayout.() -> Unit) {
        val layout = RectLayout()
        layout.apply(block)
    }

    fun name(name: String) {
        swiftdrive.name = name
    }

    fun units(vararg units: IUnit) {
        swiftdrive.unitSet.apply {
            units.forEach { unit(it) }
        }
    }

    fun unit(unit: IUnit) {
        swiftdrive.unitSet.unit(unit)
    }

    fun units(block: UnitSet.() -> Unit) {
        swiftdrive.unitSet.apply(block)
    }

    fun <T> install(interceptor: Swiftdrive.() -> T, configurer: (T.() -> Unit)? = null) {
        swiftdrive.apply {
            interceptor().also {
                configurer?.invoke(it)
            }
        }
    }
}