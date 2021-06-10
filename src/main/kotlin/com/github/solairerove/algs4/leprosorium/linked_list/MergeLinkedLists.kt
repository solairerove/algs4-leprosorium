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
    val res = mergeLinkedLists(head, head7)
    println()
    printLinkedList(res)
}

// O(n + m) time | O(1) space
private fun mergeLinkedLists(headFirst: ListNode, headSecond: ListNode): ListNode {
    var i: ListNode? = headFirst
    var prev: ListNode? = null
    var j: ListNode? = headSecond
    while (i != null && j != null) {
        if (i.value < j.value) {
            prev = i
            i = i.next
        } else {
            if (prev != null) prev.next = j
            prev = j
            j = j.next
            prev.next = i
        }
    }

    if (i == null) prev?.next = j
    return if (headFirst.value < headSecond.value) headFirst else headSecond
}
