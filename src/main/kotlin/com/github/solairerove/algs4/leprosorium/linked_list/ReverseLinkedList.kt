package com.github.solairerove.algs4.leprosorium.linked_list

fun main() {
    var head: ListNode? = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)

    head?.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5

    printLinkedList(head)
    head = reverseList(head)
    println()
    printLinkedList(head)
}

// O(n) time | O(1) space
private fun reverseList(head: ListNode?): ListNode? {
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
