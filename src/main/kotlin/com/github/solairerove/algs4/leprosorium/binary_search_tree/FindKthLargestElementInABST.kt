package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    println(findKLargestValue(node = getValidBST(), k = 2)) // 21
    println(findKLargestValue(node = getValidBST(), k = 4)) // 14
}

// O(n) time | O(n) space
private fun findKLargestValue(node: BSTNode, k: Int): Int {
    val arr = mutableListOf<Int>()
    inOrderTraversal(node, arr)
    return arr[arr.size - k]
}

// O(n) time | O(n) space
private fun inOrderTraversal(node: BSTNode?, arr: MutableList<Int>) {
    if (node != null) {
        inOrderTraversal(node.left, arr)
        arr.add(node.value)
        inOrderTraversal(node.right, arr)
    }
}
