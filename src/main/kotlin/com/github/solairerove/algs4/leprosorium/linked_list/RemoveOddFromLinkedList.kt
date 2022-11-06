package com.github.solairerove.algs4.leprosorium.linked_list

fun main() {
    var head: ListNode? = ListNode(1)
    val node2 = ListNode(2)
    val node3 = ListNode(4)
    val node4 = ListNode(3)

    head?.next = node2
    node2.next = node3
    node3.next = node4

    printLinkedList(head)
    head = deleteOdd(head)
    println()
    printLinkedList(head) // 2 4
}

// 1 2 3 4
// 1 2 4 3
// 2 1 4 3
// 2 1 1 4
// 2 4 6 1
// 1 2 4 6
// 1 2 4 1
// 1 1 1 1

// O(n) time | O(n) space
fun deleteOdd(head: ListNode?): ListNode? {
    var curr: ListNode? = head

    var evenHeadNode: ListNode? = null
    var prevEvenNode: ListNode? = null

    while (curr != null) {
        if (curr.value % 2 == 0) {
            if (evenHeadNode == null) evenHeadNode = curr else prevEvenNode?.next = curr
            prevEvenNode = curr
        }
        else {
            prevEvenNode?.next = curr.next
        }

        curr = curr.next
    }

    return evenHeadNode
}
