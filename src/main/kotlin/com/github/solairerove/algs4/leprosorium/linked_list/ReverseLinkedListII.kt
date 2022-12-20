package com.github.solairerove.algs4.leprosorium.linked_list

/**
 *  Given the head of a singly linked list and two integers left and right where left <= right,
 *  reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 *  Input: head = [1 -> 2 -> 3 -> 4 -> 5], left = 2, right = 4
 *  Output: [1 -> 4 -> 3 -> 2 -> 5]
 */

// O(n) time | O(1) space
fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    if (head == null) return null
    if (head.next == null) return head // but without works fine

    val sentinel = ListNode(-1)
    sentinel.next = head

    var curr: ListNode? = head
    var prev: ListNode? = sentinel

    var i = 1
    while (i < left) {
        prev = curr
        curr = curr?.next
        i++
    }

    val node = prev

    while (i <= right) {
        val next = curr?.next
        curr?.next = prev
        prev = curr
        curr = next
        i++
    }

    node?.next?.next = curr
    node?.next = prev

    return sentinel.next
}
