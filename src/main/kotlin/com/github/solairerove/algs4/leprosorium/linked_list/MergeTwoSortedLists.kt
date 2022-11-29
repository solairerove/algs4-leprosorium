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

// 2 1
// O(n + m) time | O(1) space
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null) return list2
    if (list2 == null) return list1

    var curr1: ListNode? = list1
    var curr2: ListNode? = list2
    var prev: ListNode? = null

    while (curr1 != null && curr2 != null) {
        if (curr1.value < curr2.value) {
//            prev?.next = curr2
//            prev = curr2
//            curr2 = curr2.next
            prev = curr1
            curr1 = curr1.next
        } else {
            if (prev != null) prev.next = curr2
            prev = curr2
            curr2 = curr2.next
            prev.next = curr1


//            prev?.next = curr1
//            prev = curr1
//            curr1 = curr1.next
        }
    }

    if (curr1 == null) prev?.next = curr2
    return if (list1.value < list2.value) list1 else list2
}
