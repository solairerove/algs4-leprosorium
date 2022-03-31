package com.github.solairerove.algs4.leprosorium.linked_list

fun main() {
    var head = ListNode(1)
    val node2 = ListNode(1)
    val node3 = ListNode(1)
    val node4 = ListNode(2)
    val node5 = ListNode(2)
    val node6 = ListNode(3)
    val node7 = ListNode(4)

    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7

    printLinkedList(head)
    head = deleteDuplicates(head)!!
    println()
    printLinkedList(head) // 3 4
}

// 1 1 1 2 2 3 4
// O(n) time | O(1) space
private fun deleteDuplicates(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var curr: ListNode? = head
    var prev: ListNode? = dummy
    prev!!.next = curr

    while (curr != null) {
        while (curr?.next != null && curr.value == (curr.next as ListNode).value) {
            curr = curr.next
        }
        if (prev?.next != curr) {
            prev?.next = curr?.next
            curr = prev?.next
        } else {
            prev = prev?.next
            curr = curr?.next
        }
    }

    return dummy.next
}
