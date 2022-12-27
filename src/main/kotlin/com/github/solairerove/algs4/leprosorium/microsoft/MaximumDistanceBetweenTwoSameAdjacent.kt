package com.github.solairerove.algs4.leprosorium.microsoft

/**
 * We are given a string S consisting of N lowercase letters.
 * A sequence of two adjacent letters inside a string is called a digram.
 * The distance between two digrams is the distance between the first letter of the first digram
 * and the first letter of the second digram.
 *
 * For example, in string S "akcmz" the distance between digrams "k" and "mz" is 2.
 *
 * We want to find the maximum distance between the furthest identical digrams inside string S.
 *
 * If there are no two identical digrams inside S, your function should S return -1.
 *
 * Examples:
 *
 * 1. Given S = "aakmaakmakda" your function should return 7.
 * The furthest identical digrams are "ak's, starting in positions 2 and 9.
 *
 * 2. Given S = "aaa" your function should return 1.
 * The furthest identical digrams are "aa's starting at positions 1 and 2.
 *
 * 3. Given S = "civic" your function should return -1.
 * There are no two identical digrams in S.
 *
 * Write an efficient algorithm for the following assumptions:
 * N is an integer within the range (2..300,000];
 * string S is made only of lowercase letters (a-z).
 */

// O(2n) time | O(n) space
fun maximumIdenticalAdjacentDistance(s: String): Int {
    if (s.length == 2) return -1

    val map = mutableMapOf<String, PairMetaInfo>()
    for (i in 0 until s.length - 1) {
        val pair = "${s[i]}${s[i + 1]}"
        if (map.contains(pair)) {
            val pairMetaInfo = map[pair]!!
            pairMetaInfo.distance = i - pairMetaInfo.firstIdx
            pairMetaInfo.havePair = true
        } else {
            val pairMetaInfo = PairMetaInfo()
            pairMetaInfo.firstIdx = i
            pairMetaInfo.distance = 0
            pairMetaInfo.havePair = false

            map[pair] = pairMetaInfo
        }
    }

    return map.filter { it.value.havePair }.maxOfOrNull { it.value.distance } ?: -1
}

private class PairMetaInfo {
    var firstIdx: Int = -1
    var distance: Int = -1
    var havePair: Boolean = false
}
