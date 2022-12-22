package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 *
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 *
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 *
 * The functions get and put must each run in O(1) average time complexity.
 */
class LRUCache(var capacity: Int) {
    private class DoublyLinkedNode {
        var key: Int = -1
        var value: Int = -1
        var prev: DoublyLinkedNode? = null
        var next: DoublyLinkedNode? = null
    }

    private val cache = hashMapOf<Int, DoublyLinkedNode>()
    private var size = 0
    private val head = DoublyLinkedNode()
    private val tail = DoublyLinkedNode()

    init {
        head.next = tail
        tail.prev = head
    }

    private fun moveToHead(node: DoublyLinkedNode) {
        removeNode(node)
        addNodeToHead(node)
    }

    private fun addNodeToHead(node: DoublyLinkedNode) {
        node.prev = head
        node.next = head.next

        head.next?.prev = node
        head.next = node
    }

    private fun removeNode(node: DoublyLinkedNode?) {
        val prev = node?.prev
        val next = node?.next

        prev?.next = next
        next?.prev = prev
    }

    private fun popTail(): DoublyLinkedNode? {
        val res = tail.prev
        removeNode(res)
        return res
    }

    fun get(key: Int): Int {
        val node: DoublyLinkedNode = cache[key] ?: return -1

        moveToHead(node)

        return node.value
    }

    fun put(key: Int, value: Int) {
        val node: DoublyLinkedNode? = cache[key]

        if (node == null) {
            val newNode = DoublyLinkedNode()
            newNode.key = key
            newNode.value = value

            cache[key] = newNode
            addNodeToHead(newNode)

            size++

            if (size > this.capacity) {
                val tail = popTail()
                cache.remove(tail?.key)
                size--
            }
        } else {
            node.value = value
            moveToHead(node)
        }
    }
}
