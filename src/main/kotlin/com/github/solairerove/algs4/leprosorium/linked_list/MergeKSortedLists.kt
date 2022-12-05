package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 * Input: lists = [[1 -> 4 -> 5], [1 -> 3 -> 4], [2 -> 6]]
 * Output: [1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6]
 * Explanation: The linked-lists are:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 */

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null
    if (lists.size == 1) return lists[0]

    var interval = 1
    while (interval < lists.size) {
        var i = 0
        while (i + interval < lists.size) {
            lists[i] = mergeTwoLists(lists[i], lists[i + interval])
            i += interval * 2
        }
        interval *= 2
    }

    return lists[0]
}

// O(kN) time | O(1) space
fun mergeKListsNaive(lists: Array<ListNode?>): ListNode? {
    if (lists.isEmpty()) return null
    if (lists.size == 1) return lists[0]

    var head = mergeTwoLists(lists[0], lists[1])
    IntRange(2, lists.size - 1).forEach { head = mergeTwoLists(head, lists[it]) }

    return head
}
