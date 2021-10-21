package com.github.solairerove.algs4.leprosorium.binary_search_tree

open class BST(var value: Int) {
    var left: BST? = null
    var right: BST? = null
}

// O(log(n)) time | O(1) space
// worst O(n) time | O(1) space
fun findTheClosestValueInBst(tree: BST, target: Int): Int {
    return findTheClosesValueInBst(tree, target, tree.value)
}

fun findTheClosesValueInBst(tree: BST?, target: Int, closest: Int): Int {
    var newClosest = closest
    var currNode = tree
    inner@ while (currNode != null) {
        if (abs(target - newClosest) > abs(target - currNode.value)) {
            newClosest = currNode.value
        }

        currNode = when {
            target < currNode.value -> currNode.left
            target > currNode.value -> currNode.right
            else -> break@inner
        }
    }

    return newClosest
}
