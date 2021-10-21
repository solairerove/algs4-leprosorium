package com.github.solairerove.algs4.leprosorium.binary_search_tree

import kotlin.math.abs

/**
          14
        /   \
       7    21
      / \  / \
     3  7 11 25
*/
fun main() {
    val root = BST(14)
    val rightNode1 = BST(11)
    val rightNode2 = BST(25)
    val rightNode3 = BST(21)
    val leftNode1 = BST(7)
    val leftNode2 = BST(7)
    val leftNode3 = BST(3)
    root.left = leftNode1
    root.right = rightNode3
    rightNode3.left = rightNode1
    rightNode3.right = rightNode2
    leftNode1.left = leftNode3
    leftNode1.right = leftNode2

    print(findTheClosestValueInBst(tree = root, target = 10))
}

private open class BST(var value: Int) {
    var left: BST? = null
    var right: BST? = null
}

// O(log(n)) time | O(1) space
// worst O(n) time | O(1) space
private fun findTheClosestValueInBst(tree: BST, target: Int): Int {
    return findTheClosestValueInBst(tree, target, tree.value)
}

private fun findTheClosestValueInBst(tree: BST?, target: Int, closest: Int): Int {
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
