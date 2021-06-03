package com.github.solairerove.algs4.leprosorium.linked_list

fun main() {
    val head = ListNode(1)
    val node2 = ListNode(1)
    val node3 = ListNode(1)
    val node4 = ListNode(2)
    val node5 = ListNode(2)
    val node6 = ListNode(3)

    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    printLinkedList(head)
    removeKNodeFromEnd(head, 2)
    println()
    printLinkedList(head)
}

// O(n) time | O(1) space
private fun removeKNodeFromEnd(head: ListNode, k: Int) {
    var cnt = 1
    var first = head
    var second: ListNode? = head

    while (cnt <= k) {
        second = second!!.next
        cnt++
    }

    if (second == null) {
        head.value = head.next!!.value
        head.next = head.next!!.next
        return
    }

    while (second!!.next != null) {
        second = second.next
        first = first.next!!
    }

    first.next = first.next!!.next
}
