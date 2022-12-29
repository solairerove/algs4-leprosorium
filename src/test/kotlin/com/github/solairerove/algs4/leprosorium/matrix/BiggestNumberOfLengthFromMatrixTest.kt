package com.github.solairerove.algs4.leprosorium.matrix

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class BiggestNumberOfLengthFromMatrixTest : StringSpec({
    "biggest four digit number from matrix test" {
        forAll(
            row(arrayOf(intArrayOf(9, 1, 1, 0, 7), intArrayOf(1, 0, 2, 1, 0), intArrayOf(1, 9, 1, 1, 0)), 9121),
            row(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 3, 4), intArrayOf(1, 4, 3)), 4343),
            row(arrayOf(intArrayOf(0, 1, 5, 0, 0)), 1500),
        ) { matrix, res ->
            biggestNumberFromMatrix(matrix) shouldBe res
        }
    }
})
