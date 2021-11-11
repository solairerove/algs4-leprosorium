package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    println(kthSmallest(getValidBST(), 2)) // 7
}

// O(n) time | O(n) space
private fun kthSmallest(root: BSTNode?, k: Int): Int {
    val arr = mutableListOf<Int>()
    inorderTraversal(root, arr)
    return arr[k - 1]
}

private fun inorderTraversal(root: BSTNode?, arr: MutableList<Int>) {
    if (root != null) {
        inorderTraversal(root.left, arr)
        arr.add(root.value)
        inorderTraversal(root.right, arr)
    }
}
