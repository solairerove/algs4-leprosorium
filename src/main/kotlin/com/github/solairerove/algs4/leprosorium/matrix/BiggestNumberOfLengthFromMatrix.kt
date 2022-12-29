package com.github.solairerove.algs4.leprosorium.matrix

import kotlin.math.max
import kotlin.math.pow

/**
 * You are given a matrix of N rows and M columns.
 * Each field of the matrix contains a single digit (0-9).
 *
 * You want to find a path consisting of four neighboring fields.
 * Two fields are neighboring if they share a common side.
 * Also, the fields in your path should be distinct (you can't visit the same field twice).
 *
 * Return the biggest integer that you can achieve values in a path of length four.
 *
 * 1. Given the following matrix (N=3, M=5):
 * [
 *  [9, 1, 1, 0, 7],
 *  [1, 0, 2, 1, 0],
 *  [1, 9, 1, 1, 0]
 * ]
 * 9121.
 *
 * 2. Given the following matrix (N=3, M=3):
 * [
 *  [1, 1, 1],
 *  [1, 3, 4],
 *  [1, 4, 3]
 * ]
 * 4343.
 *
 * 3. Given the following matrix (N=1, M=5):
 * [
 *  [0, 1, 5, 0, 0]
 * ]
 * 1500.
 *
 * N and M are integers within the range [1..100];
 * each element of matrix matrix is an integer within the range [0..9];
 * there exist a path of length 4 which doesn't start with 0.
 *
 */

// O(n * m) time | O(n + m) space
fun biggestNumberFromMatrix(matrix: Array<IntArray>): Int {
    val row = matrix.size
    val col = matrix[0].size

    // TODO: should improve dfs to delete this
    if (row == 1) {
        var ans = 0
        for (i in 0 until col - 3) ans = max(
            ans,
            "${matrix[0][i]}${matrix[0][i + 1]}${matrix[0][i + 2]}${matrix[0][i + 3]}".toInt()
        )

        for (i in col - 1 downTo 3) ans = max(
            ans,
            "${matrix[0][i]}${matrix[0][i - 1]}${matrix[0][i - 2]}${matrix[0][i - 3]}".toInt()
        )
        return ans
    }

    // TODO: should improve dfs to delete this
    if (col == 1) {
        var ans = 0
        for (i in 0 until row - 3) ans = max(
            ans,
            "${matrix[i][0]}${matrix[i + 1][0]}${matrix[i + 2][0]}${matrix[i + 3][0]}".toInt()
        )
        for (i in row - 1 downTo 3) ans = max(
            ans,
            "${matrix[i][0]}${matrix[i - 1][0]}${matrix[i - 2][0]}${matrix[i - 3][0]}".toInt()
        )
        return ans
    }

    var maxNumber = 0
    for (r in 0 until row) {
        for (c in 0 until col) {
            maxNumber = max(maxNumber, matrix[r][c])
        }
    }

    var ans = 0
    val visited = Array(row) { IntArray(col) { 0 } }
    for (r in 0 until row) {
        for (c in 0 until col) {
            if (maxNumber == matrix[r][c]) {
                val shit = dsf(matrix, r, c, 4, visited)
                ans = max(ans, shit)
            }
        }
    }

    return ans
}

private fun dsf(matrix: Array<IntArray>, row: Int, col: Int, length: Int, visited: Array<IntArray>): Int {
    if (row < 0 || col < 0 || row >= matrix.size || col >= matrix[0].size || length == 0 || visited[row][col] == 1) return 0

    val ans = matrix[row][col] * 10.0.pow(length - 1)
    visited[row][col] = 1
    var ret = ans
    ret = max(ret, ans + dsf(matrix, row + 1, col, length - 1, visited))
    ret = max(ret, ans + dsf(matrix, row - 1, col, length - 1, visited))
    ret = max(ret, ans + dsf(matrix, row, col + 1, length - 1, visited))
    ret = max(ret, ans + dsf(matrix, row, col - 1, length - 1, visited))
    visited[row][col] = 0

    return ret.toInt()
}
