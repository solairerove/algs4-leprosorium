package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a sorted linked list,
 * delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 *
 * Input: head = [1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5]
 * Output: [1 -> 2 -> 5]
 */

// O(n) time | O(n) space
fun deleteDuplicatesFromSortedII(head: ListNode?): ListNode? {
    var node: ListNode? = head ?: return null

    if (node!!.next != null && node.value == node.next!!.value) {
        while (node!!.next != null && node.value == node.next!!.value) {
            node = node.next
        }
        return deleteDuplicatesFromSortedII(node.next)
    } else {
        node.next = deleteDuplicatesFromSortedII(node.next)
    }
    return node
}

// O(n) time | O(n) space
fun deleteDuplicatesDFSFromSortedII(head: ListNode?, prev: ListNode? = null): ListNode? {
    val node: ListNode = head ?: return null
    return if (prev != null && node.value == prev.value
        || node.next != null && node.value == node.next!!.value
    ) {
        deleteDuplicatesDFSFromSortedII(node.next, node)
    } else {
        node.next = deleteDuplicatesDFSFromSortedII(node.next, node)
        node
    }
}

// O(n) time | O(1) space
fun deleteDuplicatesIterativeFromSortedII(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var curr: ListNode? = head
    var prev: ListNode? = dummy
    prev!!.next = curr

    while (curr != null) {
        while (curr?.next != null && curr.value == curr.next!!.value) {
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
