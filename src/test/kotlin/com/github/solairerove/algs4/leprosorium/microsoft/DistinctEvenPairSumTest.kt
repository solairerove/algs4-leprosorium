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
        ) { arr, res ->
            getDistinctPairUsingSet(arr) shouldBe res
            getDistinctPairUsingBoolArray(arr) shouldBe res
        }
    }
})
