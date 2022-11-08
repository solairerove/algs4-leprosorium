package com.github.solairerove.algs4.leprosorium.linked_list

/**
 *  Given the head of a linked list,
 *  find all the values that appear more than once in the list and delete the nodes that have any of those values.
 *
 *  Input: head = [1 -> 2 -> 3 -> 2]
 *  Output: [1 -> 3]
 *  Explanation: 2 appears twice in the linked list,
 *      so all 2's should be deleted. After deleting all 2's, we are left with [1,3].
 */

// O(n) time | O(n) space
fun deleteDuplicatesUnsorted(head: ListNode?): ListNode? {
    var curr: ListNode? = head
    val valueToFrequency = mutableMapOf<Int, Int>()

    while (curr != null) {
        if (valueToFrequency.containsKey(curr.value)) {
            valueToFrequency[curr.value] = valueToFrequency[curr.value]!!.plus(1)
        } else {
            valueToFrequency[curr.value] = 1
        }

        curr = curr.next
    }

    curr = head
    var newHead: ListNode? = null
    var prev: ListNode? = null

    // [2 -> 1 -> 3 -> 2]
    while (curr != null) {
        if (valueToFrequency[curr.value]!! > 1) {
            prev?.next = curr.next
        } else {
            if (newHead == null) {
                newHead = curr
            }
            prev = curr
        }
        curr = curr.next
    }

    return newHead
}
