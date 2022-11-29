package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Input: list1 = [1 -> 2 -> 4], list2 = [1 -> 3 -> 4]
 * Output: [1 -> 1 -> 2 -> 3 -> 4 -> 4]
 */

// O(n + m) time | O(1) space
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var curr1: ListNode? = list1
    var curr2: ListNode? = list2
    val sentinel = ListNode(0)
    var prev: ListNode? = sentinel

    while (curr1 != null && curr2 != null) {
        if (curr1.value <= curr2.value) {
            prev?.next = curr1
            curr1 = curr1.next
        } else {
            prev?.next = curr2
            curr2 = curr2.next
        }

        prev = prev?.next
    }

    prev?.next = curr1 ?: curr2
    return sentinel.next
}
