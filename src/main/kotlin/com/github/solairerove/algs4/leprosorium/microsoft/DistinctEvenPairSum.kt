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
        if (i == arr.size - 1) {
            if (!indices.containsAll(listOf(i, 0)) && (arr[i] + arr[0]) % 2 == 0) indices.addAll(listOf(i, 0))
        } else {
            if (!indices.containsAll(listOf(i, i + 1)) && (arr[i] + arr[i + 1]) % 2 == 0) indices.addAll(
                listOf(
                    i,
                    i + 1
                )
            )
        }
    }

    return indices.size / 2
}
