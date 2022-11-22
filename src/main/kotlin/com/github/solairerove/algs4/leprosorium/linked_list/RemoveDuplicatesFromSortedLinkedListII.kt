package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a sorted linked list,
 * delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 *
 * Input: head = [1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5]
 * Output: [1 -> 2 -> 5]
 */

// O(n) time | O(n) space
fun deleteDuplicatesFromSortedII(head: ListNode?): ListNode? {
    var curr: ListNode? = head ?: return null

    if (curr!!.next != null && curr.value == curr.next!!.value) {
        while (curr!!.next != null && curr.value == curr.next!!.value) {
            curr = curr.next
        }
        return deleteDuplicatesFromSortedII(curr.next)
    } else {
        curr.next = deleteDuplicatesFromSortedII(curr.next)
    }
    return curr
}

// O(n) time | O(n) space
fun deleteDuplicatesDFSFromSortedII(head: ListNode?, prev: ListNode? = null): ListNode? {
    val curr: ListNode = head ?: return null
    return if (prev != null && curr.value == prev.value
        || curr.next != null && curr.value == curr.next!!.value
    ) {
        deleteDuplicatesDFSFromSortedII(curr.next, curr)
    } else {
        curr.next = deleteDuplicatesDFSFromSortedII(curr.next, curr)
        curr
    }
}

// O(n) time | O(1) space
fun deleteDuplicatesIterativeFromSortedII(head: ListNode?): ListNode? {
    var curr: ListNode? = head
    val sentinel = ListNode(0)
    sentinel.next = curr
    var prev: ListNode? = sentinel

    while (curr != null) {
        if (curr.next != null && curr.value == curr.next!!.value) {
            while (curr?.next != null && curr?.value == curr?.next!!.value) curr = curr.next
            prev?.next = curr?.next
        } else {
            prev = prev?.next
        }
        curr = curr?.next
    }

    return sentinel.next
}
