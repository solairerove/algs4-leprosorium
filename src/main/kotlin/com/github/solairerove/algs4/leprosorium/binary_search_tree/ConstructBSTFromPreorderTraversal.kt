package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    val tree = bstFromPreorder(listOf(14, 7, 3, 8, 21, 15, 25))
    inOrderTraversal(tree) // 3, 7, 8, 14, 15, 21, 25
}

private var i = 0

// O(n) time | O(n) space
private fun bstFromPreorder(preorder: List<Int>): BSTNode? {
    return constructBST(preorder)
}

private fun constructBST(preorder: List<Int>, bound: Int = Int.MAX_VALUE): BSTNode? {
    if (i == preorder.size || preorder[i] > bound) return null
    val root = BSTNode(value = preorder[i++])
    root.left = constructBST(preorder, root.value)
    root.right = constructBST(preorder, bound)
    return root
}

private fun inOrderTraversal(node: BSTNode?) {
    if (node != null) {
        inOrderTraversal(node.left)
        println(node.value)
        inOrderTraversal(node.right)
    }
}
