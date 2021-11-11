package com.github.solairerove.algs4.leprosorium.binary_tree

fun main() {
    println(isSameTree(getValidTree(), getValidTree())) // true
}

// O(n) time | O(n) space
private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    if (p.value != q.value) return false
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}
