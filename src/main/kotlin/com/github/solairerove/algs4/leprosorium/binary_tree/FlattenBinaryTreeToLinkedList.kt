package com.github.solairerove.algs4.leprosorium.binary_tree

fun main() {
    val tree = getValidTree()

    flatten(tree)
    var curr: TreeNode? = tree
    while (curr != null) {
        println(curr.value)
        curr = curr.right
    }

}

private var prev: TreeNode? = null

// O(n) time | O(n) space
private fun flatten(node: TreeNode?) {
    if (node == null) return
    flatten(node.right)
    flatten(node.left)
    node.right = prev
    node.left = null
    prev = node
}
