package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * Input: head = [1 -> 2 -> 3 -> 4 -> 5], k = 2
 * Output: [2 -> 1 -> 4 -> 3 -> 5]
 */

// O(2n) time | O(1) space
fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) return head

    var oldHead: ListNode? = head
    var curr: ListNode? = head
    var prev: ListNode? = null
    var newHead: ListNode? = null
    while (curr != null) {
        curr = oldHead
        var cnt = 0
        while (cnt < k && curr != null) {
            curr = curr.next
            cnt++
        }

        if (cnt == k) {
            val revHead = reverseKNodes(oldHead, k)

            if (newHead == null) newHead = revHead

            prev?.next = revHead
            prev = oldHead
            oldHead = curr
        }
    }

    prev?.next = oldHead

    return newHead ?: oldHead
}

private fun reverseKNodes(head: ListNode?, k: Int): ListNode? {
    var curr: ListNode? = head
    var prev: ListNode? = null
    for (i in 0 until k) {
        val next = curr?.next
        curr?.next = prev
        prev = curr
        curr = next
    }

    return prev
}

// O(3n) time | O(1) space
fun reverseKGroupUsingBetween(head: ListNode?, k: Int): ListNode? {
    if (head?.next == null) return head

    var length = 0
    var curr = head
    while (curr != null) {
        length++
        curr = curr.next
    }

    var oldHead = head
    var low = 1
    var high = k
    while (high <= length) {
        oldHead = reverseBetween(oldHead, low, high) // implemented method in reverse-linked-list-ii
        low += k
        high += k
    }

    return oldHead
}
