package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * You are given the head of a linked list.
 *
 * Remove every node which has a node with a strictly greater value anywhere to the right side of it.
 *
 * Return the head of the modified linked list.
 *
 * Input: head = [5,2,13,3,8]
 * Output: [13,8]
 * Explanation: The nodes that should be removed are 5, 2 and 3.
 * - Node 13 is to the right of node 5.
 * - Node 13 is to the right of node 2.
 * - Node 8 is to the right of node 3.
 *
 * Input: head = [1,1,1,1]
 * Output: [1,1,1,1]
 * Explanation: Every node has value 1, so no nodes are removed.
 */

// O(3*n) time | O(1) space
fun removeNodes(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val reversedHead = reverseList(head)
    var curr: ListNode? = reversedHead
    while (curr?.next != null) {
        if (curr.value > curr.next!!.value) curr.next = curr.next!!.next
        else curr = curr.next
    }

    return reverseList(reversedHead)
}

// O(n) time | O(n) space
fun removeNodesStack(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val sentinel = ListNode(Int.MAX_VALUE)
    val stack = ArrayDeque(listOf(sentinel))
    var curr: ListNode? = head
    while (curr != null) {
        while (stack.first().value < curr.value) stack.removeFirst()
        stack.first().next = curr
        stack.addFirst(curr)

        curr = curr.next
    }

    return sentinel.next
}
