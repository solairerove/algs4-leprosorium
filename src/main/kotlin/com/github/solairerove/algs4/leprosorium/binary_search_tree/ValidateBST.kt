package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    print(isBST(getValidBST())) // true
}

// O(n) time | O(d) space
fun isBST(root: BSTNode?, min: Int? = null, max: Int? = null): Boolean {
    if (root == null) return true
    if (min != null && root.value <= min) return false
    if (max != null && root.value >= max) return false

    return isBST(root.left, min, root.value) && isBST(root.right, root.value, max)
}
