package co.xreos.sarin.parasite

import co.xreos.sarin.memory.IMemory

abstract class BasicParasite<T>(val selector: T) {
    abstract fun activate(memory: IMemory<T>)
}