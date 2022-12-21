package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the head of a linked list and a value x,
 * partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * Input: head = [1 -> 4 -> 3 -> 2 -> 5 -> 2], x = 3
 * Output: [1 -> 2 -> 2 -> 4 -> 3 -> 5]
 */

// O(n) time | O(1) space
fun partition(head: ListNode?, x: Int): ListNode? {
    if (head?.next == null) return head

    var greaterOrEqualList: ListNode? = ListNode(-1)
    val greaterOrEqualListHead = greaterOrEqualList

    var lessList: ListNode? = ListNode(-1)
    val lessListHead = lessList

    var curr: ListNode? = head
    while (curr != null) {
        if (curr.value >= x) {
            greaterOrEqualList?.next = curr
            greaterOrEqualList = greaterOrEqualList?.next
        } else {
            lessList?.next = curr
            lessList = lessList?.next
        }

        curr = curr.next
    }

    greaterOrEqualList?.next = null
    lessList?.next = greaterOrEqualListHead?.next

    return lessListHead?.next
}
