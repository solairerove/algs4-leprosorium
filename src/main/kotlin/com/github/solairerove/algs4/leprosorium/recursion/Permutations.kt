package com.github.solairerove.algs4.leprosorium.recursion

fun main() {
    print(permutations(listOf(1, 2))) // [[1, 2], [2, 1]]
}

// O(n*n!) time | O(n*n!) space
private fun permutations(arr: List<Int>): List<List<Int>> {
    val perms = mutableListOf<List<Int>>()
    permutations(arr.toMutableList(), 0, perms)

    return perms
}

private fun permutations(arr: MutableList<Int>, i: Int, perms: MutableList<List<Int>>) {
    val n = arr.size
    if (i == n - 1) {
        perms.add(arr.toList())
        return
    }

    for (j in i until n) {
        swap(arr, i, j)
        permutations(arr, i + 1, perms)
        swap(arr, i, j)
    }
}

private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    val tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
}
