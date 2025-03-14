package co.xreos.sarin.memory

class MapMemory<T>: IMemory<T> {
    private val map = mutableMapOf<String, T>()

    fun get(key: String): T? {
        return map[key]
    }

    fun set(key: String, value: T) {
        map[key] = value
    }

    fun remove(key: String) {
        map.remove(key)
    }

    fun clear() {
        map.clear()
    }

    fun keys(): Set<String> {
        return map.keys
    }

    fun values(): Collection<T> {
        return map.values
    }

    fun entries(): Set<Map.Entry<String, T>> {
        return map.entries
    }
}