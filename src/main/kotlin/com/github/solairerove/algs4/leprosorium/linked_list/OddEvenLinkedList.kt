package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a singly linked list,
 * group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *
 * The first node is considered odd, and the second node is even, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 *
 * Input: head = [1 -> 2 -> 3 -> 4 -> 5]
 * Output: [1 -> 3 -> 5 -> 2 -> 4]
 *
 * Input: head = [2 -> 1 -> 3 -> 5 -> 6- > 4 -> 7]
 * Output: [2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4]
 */

// O(n) time | O(1) space
fun oddEvenList(head: ListNode?): ListNode? {
    if (head == null) return null
    if (head.next == null) return head

    var currOdd: ListNode? = head
    var currEven: ListNode? = currOdd!!.next
    val evenHead: ListNode? = currEven

    while (currEven?.next != null) {
        currOdd?.next = currEven.next
        currOdd = currOdd?.next
        currEven.next = currOdd?.next
        currEven = currEven.next
    }

    currOdd?.next = evenHead

    return head
}
