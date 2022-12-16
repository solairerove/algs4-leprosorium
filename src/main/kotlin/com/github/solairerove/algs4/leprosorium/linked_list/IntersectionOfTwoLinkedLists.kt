package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 *
 * Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5].
 * From the head of B, it reads as [5,6,1,8,4,5].
 * There are 2 nodes before the intersected node in A;
 * There are 3 nodes before the intersected node in B.
 *
 * Note that the intersected node's value is not 1
 * because the nodes with value 1 in A and B (2nd node in A and 3rd node in B) are different node references.
 * In other words, they point to two different locations in memory,
 * while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same location in memory.
 */

// O(2n + 2m) time | O(1) space
fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
    var curr1: ListNode? = headA
    var curr2: ListNode? = headB
    while (curr1 != curr2) {
        curr1 = if (curr1 == null) headB else curr1.next
        curr2 = if (curr2 == null) headA else curr2.next
    }

    return curr1
}

// O(n + m) time | O(m) space
fun getIntersectionNodeSet(headA: ListNode?, headB: ListNode?): ListNode? {
    val set = mutableSetOf<ListNode>()
    var curr: ListNode? = headA
    while (curr != null) {
        set.add(curr)
        curr = curr.next
    }

    curr = headB
    while (curr != null) {
        if (set.contains(curr)) return curr
        curr = curr.next
    }

    return null
}
