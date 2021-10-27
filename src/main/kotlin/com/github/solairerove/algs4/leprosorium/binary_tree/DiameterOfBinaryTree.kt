package com.github.solairerove.algs4.leprosorium.binary_tree

import kotlin.math.max

fun main() {
    println(binaryTreeDiameter(node = getValidTree())) // 4
}

private data class TreeInfo(val diameter: Int, val height: Int)

// O(n) time | O(h) space
private fun binaryTreeDiameter(node: TreeNode?): Int {
    return getTreeInfo(node).diameter
}

private fun getTreeInfo(node: TreeNode?): TreeInfo {
    if (node == null) return TreeInfo(diameter = 0, height = 0)

    val left = getTreeInfo(node.left)
    val right = getTreeInfo(node.right)

    val longestHeight = left.height + right.height
    val maxDiameter = max(left.diameter, right.diameter)
    val currDiameter = max(longestHeight, maxDiameter)
    val currHeight = 1 + max(left.height, right.height)

    return TreeInfo(diameter = currDiameter, height = currHeight)
}
