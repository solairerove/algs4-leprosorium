package com.github.solairerove.algs4.leprosorium.linked_list

fun main() {
    var head = ListNode(1)
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
    head = removeDuplicatesFromLinkedList(head)
    println()
    printLinkedList(head)
}

// O(n) time | O(1) space
private fun removeDuplicatesFromLinkedList(linkedList: ListNode): ListNode {
    var curr: ListNode? = linkedList
    while (curr != null) {
        var next = curr.next
        while (next != null && next.value == curr.value) {
            next = next.next
        }
        curr.next = next
        curr = next
    }

    return linkedList
}
