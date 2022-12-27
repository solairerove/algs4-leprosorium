package com.github.solairerove.algs4.leprosorium.microsoft

/**
 * Given a circular array of N integers (i.e. A[0] and A[N — 1] are adjacent to each other),
 * what's the maximum number of adjacent pairs that you can form whose sum are even?
 * Note that each element can belong to at most one pair.
 *
 * Examples:
 * 1. Given A = [4, 2, 5, 8, 7, 3, 71], the function should return 2.
 * We can create two pairs with even sums: (A[0], A[1]) and (A[4], A[5]).
 * Another way to choose two pairs is: (A[0], A[1]) and (A[5], A[6]).
 *
 * 2. Given A = [14, 21, 16, 35, 22], the function should return 1.
 * There is only one qualifying pair: (A[0], A[4]).
 *
 * 3. Given A = [5, 5, 5, 5, 5, 5], the function should return 3.
 * We can create three pairs: (A[0], A(5]), (A[1], A(2) and (A(3], A[4)).
 *
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range [1.100,000];
 *
 * each element of array A is an integer within the range
 * [0..1,000,000,000].
 */

// O(n) time | O(n) space
fun getDistinctPairUsingSet(arr: IntArray): Int {
    val indices = hashSetOf<Int>()
    for (i in arr.indices) {
        val idx = if (i == arr.size - 1) Pair(i, 0) else Pair(i, i + 1)

        if (!indices.containsAll(listOf(idx.first, idx.second)) && (arr[idx.first] + arr[idx.second]) % 2 == 0) {
            indices.addAll(listOf(idx.first, idx.second))
        }
    }

    return indices.size / 2
}

// O(2n) time | O(n) space
fun getDistinctPairUsingBoolArray(arr: IntArray): Int {
    val indices = Array(arr.size) { false }
    for (i in arr.indices) {
        val idx = if (i == arr.size - 1) Pair(i, 0) else Pair(i, i + 1)

        if (!indices[idx.first] && !indices[idx.second]) {
            if ((arr[idx.first] + arr[idx.second]) % 2 == 0) {
                indices[idx.first] = true.also { indices[idx.second] = true }
            }
        }
    }

    return indices.filter { it }.size / 2
}
