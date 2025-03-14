package co.xreos.swiftdrive.engine.cached

import co.xreos.swiftdrive.engine.base.ISwiftdriveEngine
import co.xreos.swiftdrive.engine.memory.EngineMemory
import co.xreos.swiftdrive.engine.output.EngineOutput
import co.xreos.swiftdrive.layout.ILayout
import co.xreos.swiftdrive.unit.IUnit
import co.xreos.swiftdrive.util.logging.logger

abstract class CachedTransformEngine: ISwiftdriveEngine {
    private lateinit var layout: ILayout
    private lateinit var unitTransform: Map<IUnit, () -> Unit>

    override fun onEnabled() {
        if (!this::layout.isInitialized) {
            logger.e { "Layout must be set before enabling engine." }
            throw IllegalStateException("Layout must be set before enabling engine")
        }
    }

    override fun onDisabled() {}

    override fun setLayout(layout: ILayout) {
        this.layout = layout
        bakeLayout()
    }

    fun bakeLayout() {
        synchronized(layout) {
            layout.getUnits().associateWith {
                bakeUnitLayout(it)
            }.toMap()
        }
    }

    fun bakeUnitLayout(unit: IUnit): () -> Unit {
        return {
            val marker = layout.getUnitMarker(unit)

        }
    }

    override fun update(memory: EngineMemory): EngineOutput {
        return EngineOutput(emptyMap(), null)
    }
}