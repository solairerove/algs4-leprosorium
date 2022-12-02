package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [7 -> 2 -> 4 -> 3], l2 = [5 -> 6 -> 4]
 * Output: [7 -> 8 -> 0 -> 7]
 */

// O(2max(n, m)) time | O(max(n, m)) + 1 space
fun addTwoNumbersIIReverse(l1: ListNode?, l2: ListNode?): ListNode? {
    return reverseList(addTwoNumbers(reverseList(l1), reverseList(l2)))
}
