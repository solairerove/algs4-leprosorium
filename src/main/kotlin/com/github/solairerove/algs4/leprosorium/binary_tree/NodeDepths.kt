package com.github.solairerove.algs4.leprosorium.binary_tree

fun main() {
    println(nodeDepths(node = getValidTree())) // 10
}

// O(n) time | O(h) space
// n - number of nodes
// h - height of tree
private fun nodeDepths(node: TreeNode?, depth: Int = 0): Int {
    if (node == null) return 0

    return depth + nodeDepths(node.left, depth + 1) + nodeDepths(node.right, depth + 1)
}
