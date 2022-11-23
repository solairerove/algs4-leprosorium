package com.github.solairerove.algs4.leprosorium.arrays

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class TwoSumSortedTest : StringSpec({
    "two sum sorted" {
        forAll(
            row(intArrayOf(-9, -7, -6, -4, 0, 2, 3, 4, 5, 7), -1, listOf(3, 9)),
            row(intArrayOf(2, 7, 11, 15), 9, listOf(1, 2)),
            row(intArrayOf(2, 3, 4), 6, listOf(1, 3)),
            row(intArrayOf(-1, 0), -1, listOf(1, 2)),
        ) { nums, target, res ->
            twoSumSorted(nums, target).toList().sorted() shouldBe res.sorted()
        }
    }
})
