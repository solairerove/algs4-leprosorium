package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given a linked list of integers, return a similar linked list
 * with all elements having odd values removed.
 *
 * For example, your linked list values are 1 -> 2 -> 3 -> 4.
 * Your new linked list should be 2 -> 4
 *
 * Function description
 * Complete the function deleteOdd below. The function
 * must return a reference to the head ListNode of your
 * linked list which has the odd values removed.
 *
 */

// O(n) time | O(n) space
fun deleteOdd(head: ListNode?): ListNode? {
    var curr: ListNode? = head
    var evenHeadNode: ListNode? = null
    var prevEvenNode: ListNode? = null

    while (curr != null) {
        if (curr.value % 2 == 0) {
            if (evenHeadNode == null) evenHeadNode = curr else prevEvenNode?.next = curr
            prevEvenNode = curr
        } else {
            prevEvenNode?.next = curr.next
        }

        curr = curr.next
    }

    return evenHeadNode
}
