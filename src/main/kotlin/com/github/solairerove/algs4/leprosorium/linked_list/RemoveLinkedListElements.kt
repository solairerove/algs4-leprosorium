package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a linked list and an integer val,
 * remove all the nodes of the linked list that has Node.val == val, and return the new head.
 *
 * Input: head = [1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6], val = 6
 * Output: [1 -> 2 -> 3 -> 4 -> 5]
 */

// O(n) time | O(1) space
fun removeElements(head: ListNode?, value: Int): ListNode? {
    if (head == null) return null
    if (head.next == null) return if (head.value == value) null else head // TODO: remove

    var curr: ListNode? = head
    val sentinel = ListNode(0)
    var prev: ListNode? = sentinel
    sentinel.next = curr

    while (curr != null) {
        if (curr.value == value) prev?.next = curr.next
        else prev = curr
        curr = curr.next
    }

    return sentinel.next
}
