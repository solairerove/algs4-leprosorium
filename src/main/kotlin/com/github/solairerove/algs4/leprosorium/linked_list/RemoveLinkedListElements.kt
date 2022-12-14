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

    var newHead: ListNode? = head
    while (newHead?.value == value) newHead = newHead.next

    var curr: ListNode? = newHead
    while (curr?.next != null) {
        if (curr.next!!.value == value) curr.next = curr.next!!.next
        else curr = curr.next
    }

    return newHead
}
