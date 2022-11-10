package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a sorted linked list,
 * delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 *
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 */

// O(n) time | O(1) space
fun deleteDuplicatesFromSorted(head: ListNode?): ListNode? {
    var curr: ListNode? = head

    while (curr != null) {
        while (curr.next != null && curr.value == curr.next!!.value) curr.next = curr.next!!.next
        curr = curr.next
    }

    return head
}
