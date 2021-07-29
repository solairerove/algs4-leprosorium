package com.github.solairerove.algs4.leprosorium.linked_list

// TODO: rename to linked list
open class ListNode(var value: Int) {
    var next: ListNode? = null
}

// O(n) time | O(1) space
fun printLinkedList(head: ListNode?) {
    var curr: ListNode? = head
    while (curr != null) {
        print("${curr.value} ")
        val next = curr.next
        curr = next
    }
}