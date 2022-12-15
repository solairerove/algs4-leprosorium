package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list.
 * The deep copy should consist of exactly n brand-new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list such
 * that the pointers in the original list and copied list represent the same list state.
 * None of the pointers in the neww list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list,
 * where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes.
 * Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 *
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
 * or null if it does not point to any node.
 *
 * Your code will only be given the head of the original linked list.
 */

// O(n) time | O(1) space
fun copyRandomList(head: RListNode?): RListNode? {
    if (head == null) return null

    // [original] -> [copy] -> [original1] -> [copy1]
    var curr: RListNode? = head
    while (curr != null) {
        val newNode = RListNode(curr.value)
        newNode.next = curr.next
        curr.next = newNode
        curr = newNode.next
    }

    // link random
    curr = head
    while (curr != null) {
        if (curr.random != null) curr.next?.random = curr.random?.next
        curr = curr.next?.next
    }

    // unweave
    curr = head
    val newHead: RListNode? = head.next
    var copy: RListNode? = head.next
    while (curr != null) {
        curr.next = curr.next?.next
        copy?.next = copy?.next?.next

        curr = curr.next
        copy = copy?.next
    }

    return newHead
}

val oldNodeToNewNode = hashMapOf<RListNode, RListNode>()
fun copyRandomListIterative(node: RListNode?): RListNode? {
    if (node == null) return null

    var oldNode: RListNode? = node
    var newNode: RListNode? = RListNode(node.value)
    oldNodeToNewNode[oldNode!!] = newNode!!

    while (oldNode != null) {
        val random = oldNode.random
        if (random != null) newNode?.random = oldNodeToNewNode.getOrPut(random) { RListNode(random.value) }

        val next = oldNode.next
        if (next != null) newNode?.next = oldNodeToNewNode.getOrPut(next) { RListNode(next.value) }

        oldNode = oldNode.next
        newNode = newNode?.next
    }

    return oldNodeToNewNode[node]
}

// O(n) time | O(2n) space
fun copyRandomListRecursive(head: RListNode?): RListNode? {
    if (head == null) return null
    if (oldNodeToNewNode.containsKey(head)) return oldNodeToNewNode[head]

    val node = RListNode(head.value)
    oldNodeToNewNode[head] = node

    node.next = copyRandomListRecursive(head.next)
    node.random = copyRandomListRecursive(head.random)

    return node
}
