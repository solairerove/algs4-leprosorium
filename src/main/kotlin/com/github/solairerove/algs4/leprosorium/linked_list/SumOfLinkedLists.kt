package com.github.solairerove.algs4.leprosorium.linked_list

fun main() {
    val head = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(3)
    val node4 = ListNode(4)
    val node5 = ListNode(5)
    val node6 = ListNode(6)

    val head7 = ListNode(7)
    val node8 = ListNode(8)
    val node9 = ListNode(9)
    val node10 = ListNode(10)

    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6

    head7.next = node8
    node8.next = node9
    node9.next = node10

    printLinkedList(head)
    println()
    printLinkedList(head7)
    val res = sumOfLinkedLists(head, head7)
    println()
    printLinkedList(res)
}

// O(max(n + m)) time | O(max(n + m)) space
private fun sumOfLinkedLists(headFirst: ListNode, headSecond: ListNode): ListNode {
    val newHead = ListNode(0)
    var curr = newHead
    var carry = 0

    var nodeOne: ListNode? = headFirst
    var nodeTwo: ListNode? = headSecond
    while (nodeOne != null || nodeTwo != null || carry != 0) {
        val valueOne = nodeOne?.value ?: 0
        val valueTwo = nodeTwo?.value ?: 0
        val sum = valueOne + valueTwo + carry

        val newValue = sum % 10
        val newNode = ListNode(newValue)
        curr.next = newNode
        curr = newNode

        carry = sum / 10
        nodeOne = nodeOne?.next
        nodeTwo = nodeTwo?.next
    }
    return newHead.next!!
}
