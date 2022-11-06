package com.github.solairerove.algs4.leprosorium.linked_list

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
