package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given an unsorted list of nodes. The task is to remove duplicates from the list.
 *
 * Input: head = [2 -> 1 -> 3 -> 1 -> 4 -> 2 -> 3]
 * Output: [2 -> 1 -> 3 -> 4]
 * Explanation: Second occurrence o 1 and 2 is removed
 */

// O(n) time | O(n) space
fun deleteDuplicatesUnsorted(head: ListNode?): ListNode? {
    var curr: ListNode? = head
    var prev: ListNode? = null
    val hs = hashSetOf<Int>()

    while (curr != null) {
        if (hs.add(curr.value)) prev = curr else prev?.next = curr.next
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
