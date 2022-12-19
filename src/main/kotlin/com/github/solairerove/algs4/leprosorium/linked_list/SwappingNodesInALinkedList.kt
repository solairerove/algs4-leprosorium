package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values
 * of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 * Input: head = [1 -> 2 -> 3 -> 4 -> 5], k = 2
 * Output: [1 -> 4 -> 3 -> 2 -> 5]
 */

// O(n) time | O(1) space
fun swapNodes(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    if (head.next == null) return head

    var length = 0
    var slow: ListNode? = null
    var fast: ListNode? = null
    var curr: ListNode? = head
    while (curr != null) {
        fast = fast?.next
        if (++length == k) {
            slow = curr
            fast = head
        }

        curr = curr.next
    }

    val temp = slow?.value
    slow?.value = fast?.value!!
    fast.value = temp!!

    return head
}
