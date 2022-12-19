package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Given a Circular Linked List node, which is sorted in non-descending order,
 * write a function to insert a value insertVal into the list such that it remains a sorted circular list.
 * The given node can be a reference to any single node in the list
 * and may not necessarily be the smallest value in the circular list.
 *
 * If there are multiple suitable places for insertion, you may choose any place to insert the new value.
 * After the insertion, the circular list should remain sorted.
 *
 * If the list is empty (i.e., the given node is null),
 * you should create a new single circular list and return the reference to that single node.
 * Otherwise, you should return the originally given node.
 *
 * Input: head = [3 -> 4 -> 1], insertVal = 2
 * 1 -> |
 * 4 <- 3
 * Output: [3 -> 4 -> 1 -> 2]
 *
 * Explanation: In the figure above, there is a sorted circular list of three elements.
 * You are given a reference to the node with value 3, and we need to insert 2 into the list.
 * The new node should be inserted between node 1 and node 3.
 * After the insertion, the list should look like this, and we should still return node 3.
 */

// O(n) time | O(1) space
fun insert(head: ListNode?, insertVal: Int): ListNode {
    val newNode = ListNode(insertVal)

    if (head == null) {
        newNode.next = newNode
        return newNode
    }

    if (head.next == head) {
        newNode.next = head
        head.next = newNode
        return head
    }

    var curr: ListNode? = head
    while (curr != null && curr.next != head) {
        if (curr.value <= curr.next!!.value) {
            if (insertVal >= curr.value && insertVal <= curr.next!!.value) break
        } else {
            if (insertVal >= curr.value || insertVal <= curr.next!!.value) break
        }
        curr = curr.next
    }

    val next = curr?.next
    curr?.next = newNode
    newNode.next = next

    return head
}
