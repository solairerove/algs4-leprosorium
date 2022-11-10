package com.github.solairerove.algs4.leprosorium.arrays

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class TwoSumTest : StringSpec({
    "two sum" {
        forAll(
            row(intArrayOf(2, 7, 11, 15), 9, listOf(0, 1)),
            row(intArrayOf(3, 2, 4), 6, listOf(1, 2)),
            row(intArrayOf(3, 3), 6, listOf(0, 1)),
        ) { nums, target, res ->
            twoSum(nums, target).toList().sorted() shouldBe res.sorted()
        }
    }
})
