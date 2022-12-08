package com.github.solairerove.algs4.leprosorium.linked_list

/**
 * You have a browser of one tab where you start on the homepage and you can visit another url,
 * get back in the history number of steps or move forward in the history number of steps.
 *
 * Implement the BrowserHistory class:
 *
 * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
 *
 * void visit(string url) Visits url from the current page. It clears up all the forward history.
 *
 * string back(int steps) Move steps back in history.
 * If you can only return x steps in the history and steps > x, you will return only x steps.
 * Return the current url after moving back in history at most steps.
 *
 * string forward(int steps) Move steps forward in history.
 * If you can only forward x steps in the history and steps > x, you will forward only x steps.
 * Return the current url after forwarding in history at most steps.
 */

class BrowserHistory(homepage: String) {
    private class DLinkedNode(var value: String) {
        var prev: DLinkedNode? = null
        var next: DLinkedNode? = null
    }

//    private fun addAtHead(value: String) {
//        val prev: DLinkedNode? = head
//        val next: DLinkedNode? = head?.next
//
//        val node = DLinkedNode(value)
//        node.prev = prev
//        node.next = next
//        prev?.next = node
//        next?.prev = node
//    }

//    private var head: DLinkedNode? = null
//    private var tail: DLinkedNode? = null
    private var curr: DLinkedNode? = null

    init {
//        head = DLinkedNode(value = "-1")
//        tail = DLinkedNode(value = "-1")
//
//        head?.next = tail
//        tail?.prev = head
//        addAtHead(value = homepage)
//        curr = head?.next
        curr = DLinkedNode(value = homepage)
    }

    fun visit(url: String) {
//        curr?.prev = null
//        val node = DLinkedNode(url)
//        curr?.prev = node
//        node.next = curr
//        curr = node

        curr?.next = null
        val node = DLinkedNode(url)
        curr!!.next = node // tail node.next = tail
        node.prev = curr
        curr = node
    }

    fun back(steps: Int): String {
        var node: DLinkedNode? = curr
        var i = steps
        while (i-- > 0 && node?.prev != null) {
            node = node.prev
        }
        curr = node

        return node!!.value
    }

    fun forward(steps: Int): String {
        var node: DLinkedNode? = curr
        var i = steps
        while (i-- > 0 && node?.next != null) {
            node = node.next
        }
        curr = node

        return node!!.value
    }
}
