package com.github.solairerove.algs4.leprosorium.binary_search_tree

class BSTNode(var value: Int) {
    var left: BSTNode? = null
    var right: BSTNode? = null
}

/**
         14
       /   \
      7    21
     / \  / \
    3  8 15 25
 */
fun getValidBST(): BSTNode {
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

    return root
}
