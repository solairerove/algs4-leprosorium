package com.github.solairerove.algs4.leprosorium.linked_list

fun main() {
    var head = ListNode(2)
    val node2 = ListNode(1)
    val node3 = ListNode(3)
    val node4 = ListNode(1)
    val node5 = ListNode(4)
    val node6 = ListNode(2)
    val node7 = ListNode(3)

    head.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7

    printLinkedList(head)
    head = deleteDuplicates(head)
    println()
    printLinkedList(head)
}

// O(n) time | O(n) space
private fun deleteDuplicates(head: ListNode): ListNode {
    val set = hashSetOf<Int>()
    var curr: ListNode? = head
    var prev: ListNode? = null

    while (curr != null) {
        if (!set.add(curr.value)) prev?.next = curr.next else prev = curr
        curr = curr.next
    }

    return head
}

// O(nˆ2) time | O(1) space
private fun deleteDuplicatesTwoLoops(head: ListNode): ListNode {
    var curr1: ListNode? = head
    var curr2: ListNode?
    while (curr1 != null) {
        curr2 = curr1
        while (curr2 != null) {
            if (curr1.value == curr2.next?.value) {
                curr2.next = curr2.next?.next
            } else {
                curr2 = curr2.next
            }
        }
        curr1 = curr1.next
    }

    return head
}
