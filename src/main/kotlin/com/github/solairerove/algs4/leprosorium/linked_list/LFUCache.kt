package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Design and implement a data structure for a Least Frequently Used (LFU) cache.
 *
 * Implement the LFUCache class:
 *
 * LFUCache(int capacity) Initializes the object with the capacity of the data structure.
 *
 * int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
 *
 * void put(int key, int value) Update the value of the key if present,
 * or inserts the key if not already present.
 * When the cache reaches its capacity,
 * it should invalidate and remove the least frequently used key before inserting a new item.
 * For this problem, when there is a tie (i.e., two or more keys with the same frequency),
 * the least recently used key would be invalidated.
 *
 * To determine the least frequently used key, a use counter is maintained for each key in the cache.
 * The key with the smallest use counter is the least frequently used key.
 *
 * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation).
 * The use counter for a key in the cache is incremented either a get or put operation is called on it.
 *
 * The functions get and put must each run in O(1) average time complexity.
 */

class LFUCache(private var capacity: Int) {
    private val cache = hashMapOf<Int, Pair<Int, Int>>() // key to pair(freq, value)
    private val frequencies = hashMapOf<Int, LinkedHashSet<Int>>() // frequency to set of all keys with such freq
    private var minFrequency = 0

    private fun insert(key: Int, frequency: Int, value: Int) {
        cache[key] = Pair(frequency, value)
        frequencies.putIfAbsent(frequency, linkedSetOf())
        frequencies[frequency]!!.add(key)
    }

    fun get(key: Int): Int {
        val freqToValuePair = cache[key] ?: return -1
        val frequency = freqToValuePair.first

        val keys = frequencies[frequency]
        keys!!.remove(key)

        if (minFrequency == frequency && keys.isEmpty()) minFrequency++
        val value = freqToValuePair.second
        insert(key, frequency + 1, value)

        return value
    }

    fun put(key: Int, value: Int) {
        if (capacity <= 0) return

        val freqToValuePair = cache[key]
        if (freqToValuePair != null) {
            cache[key] = Pair(freqToValuePair.first, value)
            get(key)
            return
        }

        if (capacity == cache.size) {
            val keys = frequencies[minFrequency]
            val keyToDelete = keys?.iterator()?.next()
            cache.remove(keyToDelete)
            keys?.remove(keyToDelete)
        }
        minFrequency = 1
        insert(key, 1, value)
    }
}
