package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Input: head = [1 -> 2 -> 3 -> 4 -> 5], n = 2
 * Output: [1 -> 2 -> 3 -> 5]
 */

// O(n) time | O(1) space
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    if (head.next == null && n == 1) return null

    var curr: ListNode? = head
    var length = 1
    while (curr?.next != null) {
        curr = curr.next
        length++
    }

    if (length == n) return head.next

    var prevNodeToDelete: ListNode? = head
    for (i in 1 until length - n) {
        prevNodeToDelete = prevNodeToDelete?.next
    }

    prevNodeToDelete?.next = prevNodeToDelete?.next?.next

    return head
}
