package com.github.solairerove.algs4.leprosorium.hash_table

/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * Implement MyHashSet class:
 *
 * void add(key) Inserts the value key into the HashSet.
 * bool contains(key) Returns whether the value key exists in the HashSet or not.
 * void remove(key) Removes the value key in the HashSet. If key does not exist in the HashSet, do nothing.
 */

class MyHashSet {
    private val maxLen = 1000000
    private val set: Array<MutableList<Int>?> = arrayOfNulls(maxLen)

    private fun getIndex(key: Int): Int = key % maxLen

    private fun getPos(key: Int, index: Int): Int {
        val bucket = set[index] ?: return -1

        return bucket.indices.find { key == bucket[it] } ?: -1
    }

    fun add(key: Int) {
        val index = getIndex(key)
        val pos = getPos(key, index)
        if (pos < 0) {
            if (set[index] == null) set[index] = mutableListOf()
            set[index]!!.add(key)
        }
    }

    fun remove(key: Int) {
        val index = getIndex(key)
        val pos = getPos(key, index)
        if (pos >= 0) set[index]!!.removeAt(pos)
    }

    fun contains(key: Int): Boolean {
        val index = getIndex(key)
        val pos = getPos(key, index)

        return pos >= 0
    }
}
