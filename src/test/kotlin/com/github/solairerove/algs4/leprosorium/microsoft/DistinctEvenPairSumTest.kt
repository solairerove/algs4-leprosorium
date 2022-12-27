package com.github.solairerove.algs4.leprosorium.microsoft

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class DistinctEvenPairSumTest : StringSpec({
    "distinct even pair sum test" {
        forAll(
            row(intArrayOf(4, 2, 5, 8, 7, 3, 71), 2),
            row(intArrayOf(14, 21, 16, 35, 22), 1),
            row(intArrayOf(5, 5, 5, 5, 5, 5), 3),
            row(intArrayOf(1, 2, 5), 1),
            row(intArrayOf(2, 2, 5), 1),
            row(intArrayOf(2, 2, 6), 1),
            row(intArrayOf(1, 2, 2, 6), 1),
            row(intArrayOf(2, 3), 0),
            row(intArrayOf(2, 2), 1),
        ) { arr, res ->
            getDistinctPair(arr) shouldBe res
            getDistinctPairUsingSet(arr) shouldBe res
            getDistinctPairUsingBoolArray(arr) shouldBe res
        }
    }
})
