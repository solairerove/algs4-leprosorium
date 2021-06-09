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
    node5.next = node2
/*
    1 -> 2 -> 3
         |    |
         5 <- 4
*/
    print(findLoop(head)?.value) // 2
}

// O(n) time | O(1) space
private fun findLoop(head: ListNode?): ListNode? {
    var first = head?.next
    var second = first?.next
    while (first != second) {
        first = first?.next
        second = second?.next?.next
    }
    first = head
    while (first != second) {
        first = first?.next
        second = second?.next
    }

    return first
}
