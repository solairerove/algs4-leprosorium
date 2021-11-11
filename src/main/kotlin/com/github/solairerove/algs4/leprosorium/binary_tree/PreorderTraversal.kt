package com.github.solairerove.algs4.leprosorium.binary_tree

fun main() {
    println(preorderTraversal(getValidTree()))
}

// O(n) time | O(n) space
private fun preorderTraversal(root: TreeNode?, arr: MutableList<Int> = mutableListOf()): List<Int> {
    if (root != null) {
        arr.add(root.value)
        preorderTraversal(root.left, arr)
        preorderTraversal(root.right, arr)
    }
    return arr
}
