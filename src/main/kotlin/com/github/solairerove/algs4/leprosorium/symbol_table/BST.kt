package com.github.solairerove.algs4.leprosorium.symbol_table

fun main() {
    val bst = BST<String, Int>()
    bst.put("S", 0)
    bst.put("E", 1)
    bst.put("A", 2)
    bst.put("R", 3)
    bst.put("C", 4)
    bst.put("H", 5)
    bst.put("E", 6)

    println(bst.size()) // 6
    println(bst.get("E")) // 6
    println(bst.min()) // A
}

class BST<Key : Comparable<Key>, Value> {
    private var root: Node? = null

    inner class Node(var key: Key, value: Value, var n: Int) {
        var value: Value? = value
        var right: Node? = null
        var left: Node? = null
    }

    fun size(): Int = size(x = root)

    fun size(x: Node?): Int {
        if (x == null) return 0
        return x.n
    }

    fun get(key: Key): Value? = get(x = root, key = key)

    fun get(x: Node?, key: Key): Value? {
        if (x == null) return null

        val cmp = key.compareTo(x.key)
        return when {
            cmp < 0 -> get(x.left, key)
            cmp > 0 -> get(x.right, key)
            else -> x.value
        }
    }

    fun put(key: Key, value: Value) {
        root = put(x = root, key = key, value = value)
    }

    fun put(x: Node?, key: Key, value: Value): Node {
        if (x == null) return Node(key = key, value = value, n = 1)

        val cmp = key.compareTo(x.key)
        when {
            cmp < 0 -> x.left = put(x = x.left, key = key, value = value)
            cmp > 0 -> x.right = put(x = x.right, key = key, value = value)
            else -> x.value = value
        }
        x.n = size(x.left) + size(x.right) + 1

        return x
    }

    fun min(): Key = min(root!!).key

    fun min(x: Node): Node {
        if (x.left == null) return x
        return min(x.left!!)
    }
}
