package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * You are given the head of a linked list.
 *
 * The nodes in the linked list are sequentially assigned to non-empty groups
 * whose lengths form the sequence of the natural numbers (1, 2, 3, 4, ...).
 * The length of a group is the number of nodes assigned to it. In other words,
 *
 * The 1st node is assigned to the first group.
 * The 2nd and the 3rd nodes are assigned to the second group.
 * The 4th, 5th, and 6th nodes are assigned to the third group, and so on.
 * Note that the length of the last group may be less than or equal to 1 + the length of the second to last group.
 *
 * Reverse the nodes in each group with an even length, and return the head of the modified linked list.
 *
 * Input: head = [5,2,6,3,9,1,7,3,8,4]
 * Output: [5,6,2,3,9,1,4,8,3,7]
 * Explanation:
 * - The length of the first group is 1, which is odd, hence no reversal occurs.
 * - The length of the second group is 2, which is even, hence the nodes are reversed.
 * - The length of the third group is 3, which is odd, hence no reversal occurs.
 * - The length of the last group is 4, which is even, hence the nodes are reversed.
 *
 * Input: head = [1,1,0,6]
 * Output: [1,0,1,6]
 * Explanation:
 * - The length of the first group is 1. No reversal occurs.
 * - The length of the second group is 2. The nodes are reversed.
 * - The length of the last group is 1. No reversal occurs.
 *
 * Input: head = [1,1,0,6,5]
 * Output: [1,0,1,5,6]
 * Explanation:
 * - The length of the first group is 1. No reversal occurs.
 * - The length of the second group is 2. The nodes are reversed.
 * - The length of the last group is 2. The nodes are reversed.
 */

// O(n) time | O(1) space
fun reverseEvenLengthGroups(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var group = 2
    var cnt = 0
    var prev: ListNode? = head
    var curr: ListNode? = head.next
    while (curr != null) {
        if (++cnt == group) {
            if (group % 2 == 0) {
                curr = prev?.next
                prev?.next = reverseKNodes(prev?.next, cnt)
            }
            prev = curr
            cnt = 0
            group++
        }
        curr = curr?.next
    }

    if (cnt % 2 == 0 && prev?.next != null) {
        prev.next = reverseKNodes(prev.next, cnt)
    }

    return head
}

private fun reverseKNodes(head: ListNode?, k: Int): ListNode? {
    var curr: ListNode? = head
    var prev: ListNode? = null
    var i = 0
    while (curr != null && i++ < k) {
        val next = curr.next
        curr.next = prev
        prev = curr
        curr = next
    }
    head?.next = curr
    return prev
}
