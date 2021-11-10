package com.github.solairerove.algs4.leprosorium.binary_search_tree

import kotlin.math.abs

fun main() {
    print(findTheClosestValueInBst(tree = getValidBST(), target = 16))
}

// O(log(n)) time | O(1) space
// worst O(n) time | O(1) space if bst has one branch
private fun findTheClosestValueInBst(tree: BSTNode?, target: Int): Int {
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
