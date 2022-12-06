package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * Design your implementation of the linked list.
 * You can choose to use a singly or doubly linked list.
 *
 * A node in a singly linked list should have two attributes: val and next.
 * val is the value of the current node,
 * and next is a pointer/reference to the next node.
 *
 * If you want to use the doubly linked list,
 * you will need one more attribute prev to indicate the previous node in the linked list.
 * Assume all nodes in the linked list are 0-indexed.
 *
 * Implement the MyLinkedList class:
 *
 * MyLinkedList() Initializes the MyLinkedList object.
 *
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 *
 * void addAtHead(int val) Add a node of value val before the first element of the linked list.
 * After the insertion, the new node will be the first node of the linked list.
 *
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 *
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list.
 * If index equals the length of the linked list,
 * the node will be appended to the end of the linked list.
 * If index is greater than the length, the node will not be inserted.
 *
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 *
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 *
 * Output
 * [null, null, null, null, 2, null, 3]
 *
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 */

class MyDoublyLinkedList {
    private class Node(var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    private var head: Node? = Node(0)
    private var tail: Node? = Node(0)
    private var size: Int = 0

    init {
        head?.next = tail
        tail?.prev = head
    }

    // O(min(k, N - k)) time | O(1) space
    fun get(index: Int): Int {
        if (index < 0 || index >= size) return -1

        var curr: Node? = head
        if (index + 1 < size - index) {
            for (i in 0 until index + 1) curr = curr?.next
        } else {
            curr = tail
            for (i in 0 until size - index) curr = curr?.prev
        }

        return curr?.value ?: -1
    }

    // O(1) time | O(1) space
    fun addAtHead(value: Int) {
        val prev: Node? = head
        val next: Node? = head?.next

        size++

        val toAdd = Node(value)
        toAdd.prev = prev
        toAdd.next = next
        prev?.next = toAdd
        next?.prev = toAdd
    }

    // O(1) time | O(1) space
    fun addAtTail(value: Int) {
        val prev: Node? = tail?.prev
        val next: Node? = tail

        size++

        val toAdd = Node(value)
        toAdd.prev = prev
        toAdd.next = next
        prev?.next = toAdd
        next?.prev = toAdd
    }

    // O(min(k, N - k)) time | O(1) space
    fun addAtIndex(index: Int, value: Int) {
        var idx = index // kotlin

        if (idx > size) return
        if (idx < 0) idx = 0

        var prev: Node?
        var next: Node?
        if (idx < size - idx) {
            prev = head
            for (i in 0 until idx) prev = prev?.next
            next = prev?.next
        } else {
            next = tail
            for (i in 0 until size - idx) next = next?.prev
            prev = next?.prev
        }

        size++

        val toAdd = Node(value)
        toAdd.prev = prev
        toAdd.next = next
        prev?.next = toAdd
        next?.prev = toAdd
    }

    // O(min(k, N - k)) time | O(1) space
    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= size) return

        var prev: Node?
        var next: Node?
        if (index < size - index) {
            prev = head
            for (i in 0 until index) prev = prev?.next
            next = prev?.next?.next
        } else {
            next = tail
            for (i in 0 until size - index - 1) next = next?.prev
            prev = next?.prev?.prev
        }

        size--
        prev?.next = next
        next?.prev = prev
    }
}

class MySinglyLinkedList {
    private class Node(var value: Int) {
        var next: Node? = null
    }

    private var head: Node? = Node(0)
    private var size: Int = 0

    // O(k) time | O(1) space
    fun get(index: Int): Int {
        if (index < 0) return -1

        var curr: Node? = head
        for (i in 0 until index + 1) curr = curr?.next

        return curr?.value ?: -1
    }

    // O(1) time | O(1) space
    fun addAtHead(value: Int) {
        addAtIndex(0, value)
    }

    // O(N) time | O(1) space
    fun addAtTail(value: Int) {
        addAtIndex(size, value)
    }

    // O(k) time | O(1) space
    fun addAtIndex(index: Int, value: Int) {
        var idx = index // kotlin

        if (idx > size) return
        if (idx < 0) idx = 0

        size++

        var prev: Node? = head
        for (i in 0 until idx) prev = prev?.next

        val toAdd = Node(value)
        toAdd.next = prev?.next
        prev?.next = toAdd
    }

    // O(k) time | O(1) space
    fun deleteAtIndex(index: Int) {
        if (index < 0 || index >= size) return

        size--

        var prev: Node? = head
        for (i in 0 until index) prev = prev?.next
        prev?.next = prev?.next?.next
    }
}
