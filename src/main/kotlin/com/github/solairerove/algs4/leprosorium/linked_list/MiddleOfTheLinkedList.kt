package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 *
 * If there are two middle nodes, return the second middle node.
 *
 * Input: head = [1 -> 2 -> 3 -> 4 -> 5]
 * Output: [3 -> 4 -> 5]
 * Explanation: The middle node of the list is node 3.
 */

// O(n) time | O(1) space
fun middleNode(head: ListNode?): ListNode? {
    if (head == null) return null
    if (head.next == null) return head

    var slow: ListNode? = head
    var fast: ListNode? = slow?.next
    while (fast != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}
