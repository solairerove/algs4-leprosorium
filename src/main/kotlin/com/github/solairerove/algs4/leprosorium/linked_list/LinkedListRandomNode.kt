package com.github.solairerove.algs4.leprosorium.linked_list

import kotlin.random.Random

/**
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 *
 * Implement the LinkedListRandomNode class:
 *
 * LinkedListRandomNode(ListNode head) Initializes the object with the head of the singly-linked list head.
 *
 * int getRandom() Chooses a node randomly from the list and returns its value.
 * All the nodes of the list should be equally likely to be chosen.
 */

class LinkedListRandomNodeUsingReservoirSampling(private val head: ListNode?) {

    // O(n) time | O(1) space
    fun getRandom(): Int {
        var scope = 1
        var chosen = 0
        var curr: ListNode? = head
        while (curr != null) {
            if (Math.random() < 1.0 / scope) chosen = curr.value
            scope++
            curr = curr.next
        }
        return chosen
    }
}


class LinkedListRandomNodeUsingArray(head: ListNode?) {
    private val range = mutableListOf<Int>()

    // O(n) time | O(n) space
    init {
        var curr = head
        while (curr != null) {
            range.add(curr.value)
            curr = curr.next
        }
    }

    // O(1) time | O(n) space
    fun getRandom(): Int = range[Random.nextInt(range.size)]
}
