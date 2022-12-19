package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 *
 * Input: head = [1 -> 2 -> 3 -> 4]
 * Output: [2 -> 1 -> 4 -> 3]
 */

// O(n) time | O(1) space
fun swapPairs(head: ListNode?): ListNode? {
    if (head == null) return null
    if (head.next == null) return head

    val sentinel = ListNode(-1)
    sentinel.next = head

    var curr: ListNode? = head
    var prev: ListNode? = sentinel
    while (curr?.next != null) {
        val next = curr.next
        val next2 = next?.next

        prev?.next = next
        next?.next = curr
        curr.next = next2

        prev = curr
        curr = curr.next
    }

    return sentinel.next
}
