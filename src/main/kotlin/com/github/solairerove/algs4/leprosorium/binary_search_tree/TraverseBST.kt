package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    println(inOrderTraversal(node = getValidBST(), arr = mutableListOf()))
    println(preOrderTraversal(node = getValidBST(), arr = mutableListOf()))
    println(postOrderTraversal(node = getValidBST(), arr = mutableListOf()))
}

// O(n) time | O(n) space
private fun inOrderTraversal(node: BSTNode?, arr: MutableList<Int>): List<Int> {
    if (node != null) {
        inOrderTraversal(node.left, arr)
        arr.add(node.value)
        inOrderTraversal(node.right, arr)
    }
    return arr
}

// O(n) time | O(n) space
private fun preOrderTraversal(node: BSTNode?, arr: MutableList<Int>): List<Int> {
    if (node != null) {
        arr.add(node.value)
        preOrderTraversal(node.left, arr)
        preOrderTraversal(node.right, arr)
    }
    return arr
}

// O(n) time | O(n) space
private fun postOrderTraversal(node: BSTNode?, arr: MutableList<Int>): List<Int> {
    if (node != null) {
        postOrderTraversal(node.left, arr)
        postOrderTraversal(node.right, arr)
        arr.add(node.value)
    }
    return arr
}
