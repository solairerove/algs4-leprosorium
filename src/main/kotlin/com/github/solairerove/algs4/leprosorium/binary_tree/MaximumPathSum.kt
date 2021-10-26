package com.github.solairerove.algs4.leprosorium.binary_tree

import kotlin.math.max

fun main() {
    println(maxPathSum(node = getValidTree())) // 58 (15 + 7 + 3 + 8 + 25)
}

var maxValue = 0

// O(n) space | O(log(n))
fun maxPathSum(node: TreeNode?): Int {
    maxValue = Int.MIN_VALUE
    maxPathDown(node)
    return maxValue
}

fun maxPathDown(node: TreeNode?): Int {
    if (node == null) return 0
    val left = max(0, maxPathDown(node.left))
    val right = max(0, maxPathDown(node.right))
    maxValue = max(maxValue, left + right + node.value)
    return max(left, right) + node.value
}
