package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 *
 * Input: head = [1 -> 2 -> 3 -> 4 -> 5], k = 2
 * Output: [4 -> 5 -> 1 -> 2 -> 3]
 */

// O(n) time | O(1) space
fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    if (head.next == null) return head

    var tail: ListNode? = head
    var length = 1
    while (tail?.next != null) {
        length++
        tail = tail.next
    }

    val shift = k % length
    if (shift == 0) return head

    var newTail: ListNode? = head
    for (i in 1 until length - shift) {
        newTail = newTail?.next
    }

    val newHead: ListNode? = newTail?.next
    newTail?.next = null
    tail?.next = head

    return newHead
}
