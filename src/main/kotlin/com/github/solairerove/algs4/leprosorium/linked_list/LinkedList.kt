package com.github.solairerove.algs4.leprosorium.linked_list

private class Node(val value: Int) {
    var next: Node? = null
    var prev: Node? = null
}

private class LinkedList {
    private var head: Node? = null
    private var tail: Node? = null

    // O(1) time | O(1) space
    fun setHead(node: Node) {
        if (head == null) {
            head = node
            tail = node
            return
        }
        insertBefore(head!!, node)
    }

    // O(1) time | O(1) space
    fun setTail(node: Node) {
        if (tail == null) {
            setHead(node)
            return
        }
        insertAfter(tail!!, node)
    }

    // O(1) time | O(1) space
    fun insertBefore(node: Node, nodeToInsert: Node) {
        if (nodeToInsert == head && nodeToInsert == tail) return
        remove(nodeToInsert)
        nodeToInsert.prev = node.prev
        nodeToInsert.next = node
        if (node.prev == null) {
            head = nodeToInsert
        } else {
            node.prev!!.next = nodeToInsert
        }
        node.prev = nodeToInsert
    }

    // O(1) time | O(1) space
    fun insertAfter(node: Node, nodeToInsert: Node) {
        if (nodeToInsert == head && nodeToInsert == tail) return
        remove(nodeToInsert)
        nodeToInsert.prev = node
        nodeToInsert.next = node.next
        if (node.next == null) {
            tail = nodeToInsert
        } else {
            node.next!!.prev = nodeToInsert
        }
        node.next = nodeToInsert
    }

    // O(p) time | O(1) space
    fun insertAt(position: Int, nodeToInsert: Node) {
        if (position == 1) {
            setHead(nodeToInsert)
            return
        }

        var node: Node? = head
        var curr = 1
        while (node != null && curr++ != position) {
            node = node.next
        }

        if (node != null) {
            insertBefore(node, nodeToInsert)
        } else {
            setTail(nodeToInsert)
        }
    }

    // O(n) time | O(1) space
    fun removeNodesWithValue(value: Int) {
        var node: Node? = head
        while (node != null) {
            val next = node.next
            if (node.value == value) remove(node)
            node = next
        }
    }

    // O(1) time | O(1) space
    fun remove(node: Node) {
        if (node == head) head = node.next
        if (node == tail) tail = node.prev
        removeNode(node)
    }

    // O(n) time | O(1) space
    fun contains(value: Int): Boolean {
        var node: Node? = head
        while (node != null) {
            if (node.value == value) return true
            node = node.next
        }
        return false
    }

    private fun removeNode(node: Node) {
        if (node.prev != null) node.prev!!.next = node.next
        if (node.next != null) node.next!!.prev = node.prev
        node.prev = null
        node.next = null
    }
}
