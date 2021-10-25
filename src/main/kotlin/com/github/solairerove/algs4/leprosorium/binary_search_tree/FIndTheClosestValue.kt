package com.github.solairerove.algs4.leprosorium.binary_search_tree

import kotlin.math.abs

/**
          14
        /   \
       7    21
      / \  / \
     3  8 15 25
*/
fun main() {
    val root = BST(14)
    val rightNode1 = BST(15)
    val rightNode2 = BST(25)
    val rightNode3 = BST(21)
    val leftNode1 = BST(7)
    val leftNode2 = BST(8)
    val leftNode3 = BST(3)
    root.left = leftNode1
    root.right = rightNode3
    rightNode3.left = rightNode1
    rightNode3.right = rightNode2
    leftNode1.left = leftNode3
    leftNode1.right = leftNode2

    print(findTheClosestValueInBst(tree = root, target = 16))
}

private open class BST(var value: Int) {
    var left: BST? = null
    var right: BST? = null
}

// O(log(n)) time | O(1) space
// worst O(n) time | O(1) space
private fun findTheClosestValueInBst(tree: BST?, target: Int): Int {
    var closest = tree!!.value
    var node = tree

    inner@ while (node != null) {
        if (abs(target - node.value) < abs(target - closest)) closest = node.value

        node = when {
            target < node.value -> node.left
            target > node.value -> node.right
            else -> break@inner
        }
    }

    return closest
}
