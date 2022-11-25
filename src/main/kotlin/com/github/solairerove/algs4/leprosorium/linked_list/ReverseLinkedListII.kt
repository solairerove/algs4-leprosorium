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

    var i = 1
    var curr: ListNode? = head
    var prev: ListNode? = null

    var leftNodeToUpdateNext: ListNode? = null
    while (curr != null && i < left) {
        leftNodeToUpdateNext = curr
        curr = curr.next
        i++
    }

    var reversedPart: ListNode? = null
    var rightNodeToUpdateNext: ListNode? = null
    while (curr != null && i <= right) {
        reversedPart = curr
        val next = curr.next
        if (rightNodeToUpdateNext == null) rightNodeToUpdateNext = curr
        curr.next = prev
        prev = curr
        curr = next
        i++
    }

    rightNodeToUpdateNext?.next = curr
    if (leftNodeToUpdateNext == null) return reversedPart
    leftNodeToUpdateNext.next = reversedPart

    return head
}
