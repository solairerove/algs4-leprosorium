package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 *
 * Input: head = [1 -> 2 -> 2 -> 1]
 * Output: true
 */

// O(n) time | O(1) space
fun isPalindrome(head: ListNode?): Boolean {
    if (head == null) return false
    if (head.next == null) return true

    val middleNode = findMiddleNode(head)
    val reversedPart = reverseList(middleNode?.next)

    var low: ListNode? = head
    var high: ListNode? = reversedPart
    while (high != null) {
        if (low?.value != high.value) return false
        low = low.next
        high = high.next
    }

    return true
}

private fun findMiddleNode(head: ListNode?): ListNode? {
    var slow: ListNode? = head
    var fast: ListNode? = head?.next
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }

    return slow
}

// O(n) time | O(n) space
fun isPalindromeArray(head: ListNode?): Boolean {
    if (head == null) return true

    var curr: ListNode? = head
    val arr = mutableListOf<Int>()
    while (curr != null) {
        arr.add(curr.value)
        curr = curr.next
    }

    var low = 0
    var high = arr.size - 1
    while (low < high) if (arr[low++] != arr[high--]) return false

    return true
}
