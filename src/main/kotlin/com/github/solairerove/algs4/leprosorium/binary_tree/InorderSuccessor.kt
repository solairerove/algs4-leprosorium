package com.github.solairerove.algs4.leprosorium.binary_tree

fun main() {
    val tree = getValidTree()
    println(inorderSuccessor(node = tree.left!!)!!.value) // 15
}

// O(h) time | O(1) space
private fun inorderSuccessor(node: TreeNode): TreeNode? {
    if (node.right != null) return getLeftmostLeaf(node.right!!)

    return getRightmostParent(node)
}

private fun getLeftmostLeaf(node: TreeNode): TreeNode {
    var curr = node
    while (curr.left != null) {
        curr = curr.left!!
    }

    return curr
}

private fun getRightmostParent(node: TreeNode): TreeNode? {
    var curr = node
    while (curr.parent != null && curr.parent!!.right == curr) {
        curr = curr.parent!!
    }

    return curr.parent
}
