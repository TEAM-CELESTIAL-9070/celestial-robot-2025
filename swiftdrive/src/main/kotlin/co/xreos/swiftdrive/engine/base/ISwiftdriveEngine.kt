package co.xreos.swiftdrive.engine.base

import co.xreos.swiftdrive.engine.memory.EngineMemory
import co.xreos.swiftdrive.engine.output.EngineOutput
import co.xreos.swiftdrive.layout.ILayout

interface ISwiftdriveEngine {
    fun onEnabled()
    fun onDisabled()

    fun setLayout(layout: ILayout)
    fun update(memory: EngineMemory): EngineOutput
}