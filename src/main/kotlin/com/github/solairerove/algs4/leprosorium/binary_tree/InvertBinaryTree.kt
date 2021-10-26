package com.github.solairerove.algs4.leprosorium.binary_tree

fun main() {
    inOrderTraversal(getValidTree())
    println()
    val inverted = invert(getValidTree())
    inOrderTraversal(inverted) // 25 8 21 3 15 7 14
}

private fun invert(node: TreeNode?): TreeNode? {
    if (node != null) {
        swap(node)
        invert(node.left)
        invert(node.right)
    }

    return node
}

private fun swap(node: TreeNode) {
    val left = node.left
    node.left = node.right
    node.right = left
}

private fun inOrderTraversal(node: TreeNode?) {
    if (node != null) {
        inOrderTraversal(node.left)
        print("${node.value} ")
        inOrderTraversal(node.right)
    }
}
