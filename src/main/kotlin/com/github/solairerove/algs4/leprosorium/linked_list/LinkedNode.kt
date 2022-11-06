package com.github.solairerove.algs4.leprosorium.linked_list

open class ListNode(var value: Int) {
    var next: ListNode? = null

    fun toList(): List<Int> {
        var curr: ListNode? = this
        val list = mutableListOf<Int>()
        while (curr != null) {
            list.add(curr.value)
            curr = curr.next
        }

        return list
    }
}

// O(n) time | O(1) space
fun printLinkedList(head: ListNode?) {
    if (head == null) println("empty")

    var curr: ListNode? = head
    while (curr != null) {
        print("${curr.value} ")
        curr = curr.next
    }
}
