package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 *
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 *
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 * Input: head = [1 -> 2 -> 3 -> 4]
 * Output: [1 -> 4 -> 2 -> 3]
 */

// O(n) time | O(1) space
fun reorderList(head: ListNode?) {
    val middleNode = middleNode(head)
    val reversedPart = reverseList(middleNode)
    merge(head, reversedPart)
}

// O(n) time | O(1) space
private fun merge(list1: ListNode?, list2: ListNode?) {
    var curr1: ListNode? = list1
    var curr2: ListNode? = list2
    var next1: ListNode?
    var next2: ListNode?

    while (curr2?.next != null) {
        next1 = curr1?.next
        curr1?.next = curr2
        curr1 = next1

        next2 = curr2.next
        curr2.next = curr1
        curr2 = next2
    }
}
