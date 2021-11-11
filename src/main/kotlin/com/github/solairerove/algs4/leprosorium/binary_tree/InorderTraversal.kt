package com.github.solairerove.algs4.leprosorium.binary_tree

fun main() {
    println(inorderTraversal(getValidTree()))
}

// O(n) time | O(n) space
private fun inorderTraversal(root: TreeNode?, arr: MutableList<Int> = mutableListOf()): List<Int> {
    if (root != null) {
        inorderTraversal(root.left, arr)
        arr.add(root.value)
        inorderTraversal(root.right, arr)
    }
    return arr
}
