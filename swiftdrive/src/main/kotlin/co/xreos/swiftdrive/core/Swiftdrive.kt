package co.xreos.swiftdrive.core

import co.xreos.sarin.skeleton.Skeleton
import co.xreos.swiftdrive.layout.ILayout
import co.xreos.swiftdrive.lifecycle.SwiftdriveLifecycle

class Swiftdrive(block: SwiftdriveConfigurer.() -> Unit): Skeleton<SwiftdriveLifecycle>() {
    lateinit var layout: ILayout
    lateinit var name: String

    init {
        val configurer = SwiftdriveConfigurer(this)
        configurer.apply(block)
    }

    override fun onEnable() {
        super.onEnable()
    }

    override fun onDisable() {
        super.onDisable()
    }
}