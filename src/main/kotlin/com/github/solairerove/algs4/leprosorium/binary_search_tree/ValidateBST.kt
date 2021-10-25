package com.github.solairerove.algs4.leprosorium.binary_search_tree

// TODO: move construction to getValidBST
fun main() {
    val root = BSTNode(14)
    val rightNode1 = BSTNode(15)
    val rightNode2 = BSTNode(25)
    val rightNode3 = BSTNode(21)
    val leftNode1 = BSTNode(7)
    val leftNode2 = BSTNode(8)
    val leftNode3 = BSTNode(3)
    root.left = leftNode1
    root.right = rightNode3
    rightNode3.left = rightNode1
    rightNode3.right = rightNode2
    leftNode1.left = leftNode3
    leftNode1.right = leftNode2

    print(validateBST(tree = root))
}

// O(n) time | O(d) space
private fun validateBST(tree: BSTNode): Boolean {
    return isBST(node = tree, min = Int.MIN_VALUE, max = Int.MAX_VALUE)
}

private fun isBST(node: BSTNode?, min: Int?, max: Int?): Boolean {
    if (node == null) return true
    if (min != null && node.value < min) return false
    if (max != null && node.value >= max) return false
    return isBST(node.left, min, node.value) && isBST(node.right, node.value, max)
}
