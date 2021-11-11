package com.github.solairerove.algs4.leprosorium.binary_tree

fun main() {
    println(postorderTraversal(getValidTree()))
}

// O(n) time | O(n) space
private fun postorderTraversal(root: TreeNode?, arr: MutableList<Int> = mutableListOf()): List<Int> {
    if (root != null) {
        postorderTraversal(root.left, arr)
        postorderTraversal(root.right, arr)
        arr.add(root.value)
    }
    return arr
}
