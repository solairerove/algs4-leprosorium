package com.github.solairerove.algs4.leprosorium.binary_tree

fun main() {
    println(branchSums(node = getValidTree())) // [24, 25, 32, 36]
}

// O(n) time | O(n) space
private fun branchSums(node: TreeNode): List<Int> {
    val sums = mutableListOf<Int>()
    calculate(node, 0, sums)

    return sums
}

private fun calculate(node: TreeNode?, sum: Int, sums: MutableList<Int>) {
    if (node == null) return

    val currSum = sum + node.value
    if (node.left == null && node.right == null) {
        sums.add(currSum)
        return
    }

    calculate(node.left, currSum, sums)
    calculate(node.right, currSum, sums)
}
