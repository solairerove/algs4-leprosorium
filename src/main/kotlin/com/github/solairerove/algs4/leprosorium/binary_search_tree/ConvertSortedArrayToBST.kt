package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    val bst = sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
    inOrderTraversal(bst)
}

// O(n) time | O(n) space
fun sortedArrayToBST(arr: IntArray, low: Int = 0, high: Int = arr.size): BSTNode? {
    if (high < low) return null

    val mid = low + (high - low) / 2
    val bst = BSTNode(arr[mid])
    bst.left = sortedArrayToBST(arr, low, mid - 1)
    bst.right = sortedArrayToBST(arr, mid + 1, high)
    return bst
}

private fun inOrderTraversal(node: BSTNode?) {
    if (node != null) {
        inOrderTraversal(node.left)
        println(node.value)
        inOrderTraversal(node.right)
    }
}
