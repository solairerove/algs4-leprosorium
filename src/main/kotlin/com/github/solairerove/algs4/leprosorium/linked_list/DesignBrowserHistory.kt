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
    private class DLinkedNode(val value: String) {
        var prev: DLinkedNode? = null
        var next: DLinkedNode? = null
    }

    private var curr: DLinkedNode? = DLinkedNode(homepage)

    fun visit(url: String) {
        curr?.next = null

        val node = DLinkedNode(url)
        node.prev = curr
        curr?.next = node
        curr = node
    }

    fun back(steps: Int): String {
        var prev: DLinkedNode? = curr
        var i = 0
        while (i++ < steps && prev?.prev != null) prev = prev.prev
        curr = prev

        return prev!!.value
    }

    fun forward(steps: Int): String {
        var next: DLinkedNode? = curr
        var i = 0
        while (i++ < steps && next?.next != null) next = next.next
        curr = next

        return next!!.value
    }
}
