package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    val tree = bstFromPreorder(intArrayOf(14, 7, 3, 8, 21, 15, 25))
    inOrderTraversal(tree) // 3, 7, 8, 14, 15, 21, 25
}

// O(n) time | O(n) space
private var i = 0
private fun bstFromPreorder(preorder: IntArray, bound: Int = Int.MAX_VALUE): BSTNode? {
    if (i == preorder.size || preorder[i] > bound) return null
    val root = BSTNode(preorder[i++])
    root.left = bstFromPreorder(preorder, root.value)
    root.right = bstFromPreorder(preorder, bound)
    return root
}

private fun inOrderTraversal(node: BSTNode?) {
    if (node != null) {
        inOrderTraversal(node.left)
        println(node.value)
        inOrderTraversal(node.right)
    }
}
