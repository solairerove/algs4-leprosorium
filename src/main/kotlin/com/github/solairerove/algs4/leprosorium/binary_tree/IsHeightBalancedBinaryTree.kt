package com.github.solairerove.algs4.leprosorium.binary_tree

import kotlin.math.abs
import kotlin.math.max

fun main() {
    println(isBalanced(getValidTree())) // true
}

data class IsBalancedTreeInfo(val isBalanced: Boolean, val height: Int)

// O(n) time | O(h) space
private fun isBalanced(node: TreeNode?): Boolean {
    return getTreeInfo(node).isBalanced
}

private fun getTreeInfo(node: TreeNode?): IsBalancedTreeInfo {
    if (node == null) return IsBalancedTreeInfo(isBalanced = true, height = -1)

    val left = getTreeInfo(node.left)
    val right = getTreeInfo(node.right)

    val isBalanced = left.isBalanced && right.isBalanced
            && abs(left.height - right.height) <= 1

    val height = max(left.height, right.height) + 1
    return IsBalancedTreeInfo(isBalanced, height)
}
