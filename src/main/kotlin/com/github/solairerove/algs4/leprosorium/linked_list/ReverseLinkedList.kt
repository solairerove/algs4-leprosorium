package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 */

// O(n) time | O(1) space
fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var curr: ListNode? = head

    while (curr != null) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }

    return prev
}
