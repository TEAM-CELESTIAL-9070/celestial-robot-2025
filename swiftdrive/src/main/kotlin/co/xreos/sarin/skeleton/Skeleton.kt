package co.xreos.sarin.skeleton

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

abstract class Skeleton<L> {
    private val children: MutableMap<L, MutableList<Skeleton<L>>> = HashMap()
    private val lock: Lock = ReentrantLock()

    open fun onEnable() {}
    open fun onDisable() {}

    open fun push(state: L) {}

    fun attachParasite(state: L, parasite: Skeleton<L>) {
        lock.lock()
        try {
            children.getOrPut(state) { ArrayList() }.add(parasite)
        } finally {
            lock.unlock()
        }
    }
}