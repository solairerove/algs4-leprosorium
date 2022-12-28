package com.github.solairerove.algs4.leprosorium.greedy

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class EqualSumArraysWithMinimumNumberOfOperationsTest : StringSpec({
    "equal sum arrays with minimum number of operations test" {
        forAll(
//            row(intArrayOf(5), intArrayOf(1, 1, 6), 1),
            row(intArrayOf(2, 3, 1, 1, 2), intArrayOf(5, 4, 6), 2),
//            row(intArrayOf(5, 4, 1, 2, 6, 5), intArrayOf(2), 6),
//            row(intArrayOf(1, 2, 3, 4, 3, 2, 1), intArrayOf(6), -1),
//            row(intArrayOf(1, 2, 3, 4, 5, 6), intArrayOf(1, 1, 2, 2, 2, 2), 3),
//            row(intArrayOf(1, 1, 1, 1, 1, 1, 1), intArrayOf(6), -1),
//            row(intArrayOf(6, 6), intArrayOf(1), 3),

            ) { arr1, arr2, res ->
            minOperations(arr1, arr2) shouldBe res
        }
    }
})
