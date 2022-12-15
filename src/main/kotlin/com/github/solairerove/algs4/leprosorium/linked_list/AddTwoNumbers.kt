package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2 -> 4 -> 3], l2 = [5 -> 6 -> 4]
 * Output: [7 -> 0 -> 8]
 * Explanation: 342 + 465 = 807.
 */

// O(max(n, m)) time | O(max(n, m)) + 1 space
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    val sentinel = ListNode(-1)
    var prev: ListNode? = sentinel

    var curr1: ListNode? = l1
    var curr2: ListNode? = l2
    var inMemory = 0
    while (curr1 != null || curr2 != null) {
        val sum = (curr1?.value ?: 0) + (curr2?.value ?: 0) + inMemory
        inMemory = sum / 10
        prev?.next = ListNode(sum % 10)

        curr1 = curr1?.next
        curr2 = curr2?.next
        prev = prev?.next
    }

    if (inMemory != 0) prev?.next = ListNode(inMemory)

    return sentinel.next
}
