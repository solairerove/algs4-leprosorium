package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    print(validateBST(tree = getValidBST()))
}

// O(n) time | O(d) space
private fun validateBST(tree: BSTNode): Boolean {
    return isBST(node = tree, min = Int.MIN_VALUE, max = Int.MAX_VALUE)
}

private fun isBST(node: BSTNode?, min: Int?, max: Int?): Boolean {
    if (node == null) return true
    if (min != null && node.value < min) return false
    if (max != null && node.value >= max) return false
    return isBST(node.left, min, node.value) && isBST(node.right, node.value, max)
}
