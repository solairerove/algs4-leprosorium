package com.github.solairerove.algs4.leprosorium.hash_table

import kotlin.random.Random

/**
 * Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 *
 * bool insert(int val) Inserts an item val into the set if not present.
 * Returns true if the item was not present, false otherwise.
 *
 * bool remove(int val) Removes an item val from the set if present.
 * Returns true if the item was present, false otherwise.
 *
 * int getRandom() Returns a random element from the current set of elements
 * (it's guaranteed that at least one element exists when this method is called).
 * Each element must have the same probability of being returned.
 *
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */

class RandomizedSet {
    private val map = mutableMapOf<Int, Int>() // value to index
    private val list = mutableListOf<Int>() // value
    private val random = Random

    // O(1) time | O(n) space
    fun insert(value: Int): Boolean {
        if (map.containsKey(value)) return false

        map[value] = list.size
        list.add(value)

        return true
    }

    // O(1) time | O(n) space
    fun remove(value: Int): Boolean {
        if (!map.containsKey(value)) return false

        val lastValue = list.last()
        val idx = map[value]!!

        list[idx] = lastValue
        map[lastValue] = idx

        list.removeAt(list.size - 1)
        map.remove(value)

        return true
    }

    // O(1) time | O(n) space
    fun getRandom(): Int = list[random.nextInt(list.size)]
}
