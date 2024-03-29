package com.github.solairerove.algs4.leprosorium.linked_list

// interface and super toList() method
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

open class DListNode(var value: Int) {
    var prev: DListNode? = null
    var next: DListNode? = null
    var child: DListNode? = null

    fun toList(): List<Int> {
        var curr: DListNode? = this
        val list = mutableListOf<Int>()
        while (curr != null) {
            list.add(curr.value)
            curr = curr.next
        }

        return list
    }
}

open class RListNode(var value: Int) {
    var next: RListNode? = null
    var random: RListNode? = null

    fun toList(): List<Int> {
        var curr: RListNode? = this
        val list = mutableListOf<Int>()
        while (curr != null) {
            list.add(curr.value)
            curr = curr.next
        }

        return list
    }
}
