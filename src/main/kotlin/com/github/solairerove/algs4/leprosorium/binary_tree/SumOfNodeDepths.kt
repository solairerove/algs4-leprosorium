package com.github.solairerove.algs4.leprosorium.binary_tree

fun main() {
    print(sumOfNodeDepths(getValidTree())) // 14
}

// O(n) time | O(h) space
private fun sumOfNodeDepths(node: TreeNode?, depth: Int = 0): Int {
    if (node == null) return 0

    val depthSum = (depth * (depth + 1)) / 2
    return depthSum + sumOfNodeDepths(node.left, depth + 1) + sumOfNodeDepths(node.right, depth + 1)
}
