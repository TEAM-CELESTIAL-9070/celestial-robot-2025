package co.xreos.swiftdrive.core

import co.xreos.swiftdrive.layout.ILayout

class Swiftdrive(block: SwiftdriveConfigurer.() -> Unit) {
    lateinit var layout: ILayout
    lateinit var name: String

    init {
        val configurer = SwiftdriveConfigurer(this)
        configurer.apply(block)
    }
}