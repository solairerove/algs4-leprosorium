package com.github.solairerove.algs4.leprosorium.hash_table

/**
 * Design a HashMap without using any built-in hash table libraries.
 *
 * Implement the MyHashMap class:
 *
 * MyHashMap() initializes the object with an empty map.
 *
 * void put(int key, int value) inserts a (key, value) pair into the HashMap.
 * If the key already exists in the map, update the corresponding value.
 *
 * int get(int key) returns the value to which the specified key is mapped,
 * or -1 if this map contains no mapping for the key.
 *
 * void remove(key) removes the key and its corresponding value if the map contains the mapping for the key.
 */

// TODO: try to to using doubly linked node
class MyHashMap {
    private val maxLen = 1000000
    private val map: Array<MutableList<Pair<Int, Int>>?> = arrayOfNulls(maxLen)

    private fun getIndex(key: Int): Int = key % maxLen

    private fun getPositionInBucket(key: Int, index: Int): Int {
        val bucket = map[index] ?: return -1

        return bucket.indices.find { bucket[it].first == key } ?: -1
    }

    fun put(key: Int, value: Int) {
        val index = getIndex(key)
        val pos = getPositionInBucket(key, index)
        if (pos < 0) {
            if (map[index] == null) map[index] = mutableListOf()
            map[index]!!.add(Pair(key, value))
        } else {
            map[index]!![pos] = Pair(key, value)
        }
    }

    fun get(key: Int): Int {
        val index = getIndex(key)
        val pos = getPositionInBucket(key, index)

        return if (pos < 0) -1 else map[index]!![pos].second
    }

    fun remove(key: Int) {
        val index = getIndex(key)
        val pos = getPositionInBucket(key, index)
        if (pos >= 0) map[index]!!.removeAt(pos)
    }
}
