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
