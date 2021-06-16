package com.github.solairerove.algs4.leprosorium.linked_list

import kotlin.math.abs

fun main() {
    var head = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)

    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    printLinkedList(head)
    head = shiftLinkedList(head, 2)
    println()
    printLinkedList(head)
}

// O(n) time | O(1) space
private fun shiftLinkedList(head: ListNode, k: Int): ListNode {
    var length = 1
    var tail = head
    while (tail.next != null) {
        tail = tail.next!!
        length++
    }

    val shift = abs(k) % length
    if (shift == 0) return head
    val newPosition = if (k > 0) length - shift else shift
    var newTail = head
    for (i in 1 until newPosition) {
        newTail = newTail.next!!
    }

    val newHead = newTail.next!!
    newTail.next = null
    tail.next = head

    return newHead
}
