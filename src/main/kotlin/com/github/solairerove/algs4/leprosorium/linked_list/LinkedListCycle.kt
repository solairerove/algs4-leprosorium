package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 *
 * There is a cycle in a linked list
 * if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 *
 * Note that pos is not passed as a parameter.
 *
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 *
 * Input: head = [3 -> 2 -> 0 -> -4], pos = 1
 * 3 -> 2 -> 0
 *      |    |
 *      <-  -4
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 */

// O(n) time | O(1) space - Floyd's Cycle Finding Algorithm
// O(n) time | O(n) space - using hash set
fun hasCycle(head: ListNode?): Boolean {
    if (head == null) return false

    var slow: ListNode? = head
    var fast: ListNode? = head.next
    while (slow != fast) {
        if (fast?.next == null) return false

        slow = slow?.next
        fast = fast.next?.next
    }

    return true
}
