package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    print(isBST(node = getValidBST())) // true
}

// O(n) time | O(d) space
fun isBST(node: BSTNode?, min: Int? = Int.MIN_VALUE, max: Int? = Int.MAX_VALUE): Boolean {
    if (node == null) return true
    if (min != null && node.value < min) return false
    if (max != null && node.value >= max) return false
    return isBST(node.left, min, node.value) && isBST(node.right, node.value, max)
}
