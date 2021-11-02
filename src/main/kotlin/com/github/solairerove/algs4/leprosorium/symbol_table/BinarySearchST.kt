package com.github.solairerove.algs4.leprosorium.symbol_table

fun main() {
    val binarySearchST = BinarySearchST<String, Int>()
    binarySearchST.put("S", 0)
    binarySearchST.put("E", 1)
    binarySearchST.put("A", 2)
    binarySearchST.put("R", 3)
    binarySearchST.put("C", 4)
    binarySearchST.put("H", 5)
    binarySearchST.put("E", 6)

    println(binarySearchST.get("E")) // 6
}

private const val INITIAL_CAPACITY = 2

class BinarySearchST<Key : Comparable<Key>, Value> {

    private var keys: MutableList<Key?>
    private var vals: MutableList<Value?>
    private var n: Int = 0

    constructor() : this(INITIAL_CAPACITY)

    constructor(capacity: Int) {
        keys = MutableList(capacity) { null }
        vals = MutableList(capacity) { null }
    }

    fun size() = n

//    private fun rank(key: Key, low: Int, high: Int): Int {
//        if (high < low) return low
//
//        val mid = low + (high - low) / 2
//        val cmp = key.compareTo(keys[mid])
//
//        return when {
//            cmp < 0 -> rank(key, low, mid - 1)
//            cmp > 0 -> rank(key, mid + 1, high)
//            else -> mid
//        }
//    }

    fun delete(key: Key) = put(key, null)

    fun isEmpty(): Boolean = size() == 0

    fun contains(key: Key): Boolean = get(key) == null

    fun put(key: Key, value: Value?) {
        val i = rank(key)
        if (i < size() && keys[i]?.compareTo(key) == 0) {
            vals[i] = value
            return
        }


        for (j in size() downTo i + 1) {
                keys[j] = keys[j - 1]
                vals[j] = vals[j - 1]
        }

        keys.add(i, key)
        vals.add(i, value)
        n++
    }

    fun get(key: Key): Value? {
        if (isEmpty()) return null

        val i = rank(key)
        return if (i < size() && keys[i]?.compareTo(key) == 0) vals[i]
        else null
    }

    private fun rank(key: Key): Int {
        var low = 0
        var high = size() - 1

        while (low <= high) {
            val mid = low + (high - low) / 2
            val cmp = key.compareTo(keys[mid]!!)
            when {
                cmp < 0 -> high = mid - 1
                cmp > 0 -> low = mid + 1
                else -> return mid
            }
        }

        return low
    }
}
