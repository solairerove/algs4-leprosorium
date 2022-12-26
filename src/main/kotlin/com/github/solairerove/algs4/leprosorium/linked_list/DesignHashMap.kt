package com.github.solairerove.algs4.leprosorium.linked_list

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

class MyHashMap {
    private class Node { // TODO: constructor
        var key: Int = -1
        var value: Int = -1
        var next: Node? = null // TODO: prev
    }

    // TODO: bucket?
    // head
    // tail
    // no need dlinKedNode

    var n: Int = -1 // number of key/value pairs
    var m: Int = -1 // hashtable size // TODO: size
    private var st: Array<Node?> // TODO: List

    init {
        this.n = 0
        this.m = 2048
        this.st = Array(this.m) { null }
    }

    private fun hash(key: Int): Int = key.hashCode() % m

    fun put(key: Int, value: Int) {
        val index = hash(key)
        var curr: Node? = st[index]
        while (curr != null) {
            if (key == curr.key) {
                curr.value = value
                return
            }
            curr = curr.next
        }

        n++
        val newNode = Node()
        newNode.key = key
        newNode.value = value
        newNode.next = st[index]
        st[index] = newNode
    }

    fun get(key: Int): Int {
        val index = hash(key)
        var curr: Node? = st[index]
        while (curr != null) {
            if (key == curr.key) return curr.value
            curr = curr.next
        }

        return -1
    }

    fun remove(key: Int) {
        val index = hash(key)
        var curr: Node? = st[index]
        var prev: Node? = null
        while (curr != null) {
            if (key == curr.key) prev?.next = curr.next
            prev = curr
            curr = curr.next
        }
    }
}
