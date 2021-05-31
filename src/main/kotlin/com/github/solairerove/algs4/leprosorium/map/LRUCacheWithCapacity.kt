package com.github.solairerove.algs4.leprosorium.map

open class LRUCacheWithCapacity<K, V>(
    private val capacity: Int,
    loadFactor: Float = 0.75F,
    accessOrder: Boolean = true
) : LinkedHashMap<K, V>(
    capacity,
    loadFactor,
    accessOrder
) {
    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<K, V>?): Boolean {
        return this.size > capacity
    }
}

fun main() {
    val cache = LRUCacheWithCapacity<String, String>(3)
    cache["some_key"] = "some_value"
    cache["some_key"]
    cache["some_key_2"] = "some_value_2"
    cache["some_key"]
    cache["some_key_3"] = "some_value_3"
    cache["some_key_4"] = "some_value_4"

    print(cache)
}
