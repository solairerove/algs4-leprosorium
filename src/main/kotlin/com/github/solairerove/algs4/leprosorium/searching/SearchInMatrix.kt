package com.github.solairerove.algs4.leprosorium.searching

fun main() {
    val matrix = listOf(
        listOf(-20, -18, -12, -1, 1, 2, 4, 7, 16, 18),
        listOf(-15, -13, -10, -9, -2, 1, 2, 7, 10, 14),
        listOf(-20, -18, -12, -6, 11, 14, 16, 18, 19, 20),
        listOf(-20, -19, -11, -7, -6, -4, 11, 12, 14, 15),
        listOf(-18, -15, -8, -5, -2, 0, 2, 6, 8, 18),
        listOf(-15, -11, -10, -8, -1, 5, 12, 16, 17, 20),
        listOf(-19, -16, -12, -9, 0, 3, 5, 7, 14, 20),
        listOf(-17, -16, -11, -10, -4, 1, 2, 5, 7, 15)
    )

    print(searchInMatrix(matrix, -11)) // 5 1
}

// O(n + m) time | O(1) space
private fun searchInMatrix(matrix: List<List<Int>>, target: Int): List<Int> {
    var row = 0
    var col = matrix[0].size - 1

    while (row < matrix.size && col >= 0) {
        when {
            matrix[row][col] < target -> row++
            matrix[row][col] > target -> col--
            else -> return listOf(row, col)
        }
    }

    return listOf(-1, -1)
}
