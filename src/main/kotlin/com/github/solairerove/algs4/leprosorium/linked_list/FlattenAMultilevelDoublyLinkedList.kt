package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * You are given a doubly linked list,
 * which contains nodes that have a next pointer, a previous pointer, and an additional child pointer.
 * This child pointer may or may not point to a separate doubly linked list,
 * also containing these special nodes.
 * These child lists may have one or more children of their own, and so on,
 * to produce a multilevel data structure as shown in the example below.
 *
 * Given the head of the first level of the list,
 * flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * Let curr be a node with a child list.
 * The nodes in the child list should appear after curr and before curr.next in the flattened list.
 *
 * Return the head of the flattened list. The nodes in the list must have all of their child pointers set to null.
 *
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation: The multilevel linked list in the input is shown.
 */

private var prev: DListNode? = null

// O(n) time | O(n) space
fun flatten(head: DListNode?): DListNode? {
    if (head == null) return null

    val sentinel = DListNode(-1)
    sentinel.next = head

    flattenDFS(sentinel, head)

    sentinel.next?.prev = null

    return sentinel.next
}

private fun flattenDFS(prev: DListNode?, curr: DListNode?): DListNode? {
    if (curr == null) return prev

    curr.prev = prev
    prev?.next = curr

    val next = curr.next
    val tail = flattenDFS(curr, curr.child)
    curr.child = null

    return flattenDFS(tail, next)
}
