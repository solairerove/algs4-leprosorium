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
    private class DLinkedNode {
        var key: Int = -1
        var value: Int = -1
        var prev: DLinkedNode? = null
        var next: DLinkedNode? = null
    }

    private val cache = hashMapOf<Int, DLinkedNode>()
    private var size: Int = 0
    private var head: DLinkedNode? = null
    private var tail: DLinkedNode? = null

    init {
        head = DLinkedNode()
        tail = DLinkedNode()

        head?.next = tail
        tail?.prev = head
    }

    // head -> [] -> tail
    // head <- [] <- tail
    // add node right after head
    private fun addNode(node: DLinkedNode?) {
        node?.prev = head
        node?.next = head?.next

        head?.next?.prev = node
        head?.next = node
    }

    private fun removeNode(node: DLinkedNode?) {
        val prev: DLinkedNode? = node?.prev
        val next: DLinkedNode? = node?.next

        prev?.next = next
        next?.prev = prev
    }

    private fun moveToHead(node: DLinkedNode?) {
        removeNode(node)
        addNode(node)
    }

    private fun popTail(): DLinkedNode? {
        val res: DLinkedNode? = tail?.prev
        removeNode(res)
        return res
    }

    fun get(key: Int): Int {
        val node: DLinkedNode = cache[key] ?: return -1

        moveToHead(node)

        return node.value
    }

    fun put(key: Int, value: Int) {
        val node: DLinkedNode? = cache[key]

        if (node == null) {
            val newNode = DLinkedNode()
            newNode.key = key
            newNode.value = value

            cache[key] = newNode
            addNode(newNode)

            size++

            if (size > this.capacity) {
                val tail: DLinkedNode? = popTail()
                cache.remove(tail?.key)
                size--
            }
        } else {
            node.value = value
            moveToHead(node)
        }
    }
}
