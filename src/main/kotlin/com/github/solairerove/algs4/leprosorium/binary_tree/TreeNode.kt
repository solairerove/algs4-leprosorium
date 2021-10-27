package com.github.solairerove.algs4.leprosorium.binary_tree

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    val parent: TreeNode? = null
}

/**
         3
       /   \
      7     8
     / \   / \
    14 15 21 25
 */
fun getValidTree(): TreeNode {
    val root = TreeNode(3)
    val leftNode1 = TreeNode(7)
    val rightNode3 = TreeNode(8)
    val leftNode3 = TreeNode(14)
    val leftNode2 = TreeNode(15)
    val rightNode1 = TreeNode(21)
    val rightNode2 = TreeNode(25)

    root.left = leftNode1
    root.right = rightNode3
    rightNode3.left = rightNode1
    rightNode3.right = rightNode2
    leftNode1.left = leftNode3
    leftNode1.right = leftNode2

    return root
}
