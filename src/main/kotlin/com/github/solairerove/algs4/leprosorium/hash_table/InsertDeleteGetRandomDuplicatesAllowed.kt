package com.github.solairerove.algs4.leprosorium.hash_table

import kotlin.random.Random

/**
 * RandomizedCollection is a data structure that contains a collection of numbers,
 * possibly duplicates (i.e., a multiset).
 * It should support inserting and removing specific elements and also removing a random element.
 *
 * Implement the RandomizedCollection class:
 *
 * RandomizedCollection() Initializes the empty RandomizedCollection object.
 *
 * bool insert(int val) Inserts an item val into the multiset, even if the item is already present.
 * Returns true if the item is not present, false otherwise.
 *
 * bool remove(int val) Removes an item val from the multiset if present.
 * Returns true if the item is present, false otherwise.
 * Note that if val has multiple occurrences in the multiset, we only remove one of them.
 *
 * int getRandom() Returns a random element from the current multiset of elements.
 * The probability of each element being returned is linearly related
 * to the number of same values the multiset contains.
 *
 * You must implement the functions of the class such that each function works on average O(1) time complexity.
 *
 * Note: The test cases are generated such that getRandom will only be called
 * if there is at least one item in the RandomizedCollection.
 */

class RandomizedCollection {
    private val map = mutableMapOf<Int, LinkedHashSet<Int>>() // value to set of idx
    private val list = mutableListOf<Int>() // values
    private val random = Random

    // O(n) time | O(n) space
    fun insert(value: Int): Boolean {
        if (!map.containsKey(value)) map[value] = linkedSetOf()

        map[value]!!.add(list.size)
        list.add(value)

        return map[value]!!.size == 1
    }

    // O(n) time | O(n) space
    fun remove(value: Int): Boolean {
        if (!map.containsKey(value) || map[value]?.size == 0) return false

        val removeIdx = map[value]!!.iterator().next()
        map[value]!!.remove(removeIdx)

        val last = list.last()
        list[removeIdx] = last

        map[last]!!.add(removeIdx)
        map[last]!!.remove(list.size - 1)
        list.removeLast()

        return true
    }

    // O(n) time | O(n) space
    fun getRandom() = list[random.nextInt(list.size)]
}
