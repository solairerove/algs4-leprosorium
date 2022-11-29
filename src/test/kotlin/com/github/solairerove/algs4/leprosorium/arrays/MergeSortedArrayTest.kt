package com.github.solairerove.algs4.leprosorium.arrays

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MergeSortedArrayTest : StringSpec({
    "merge sorted array" {
        forAll(
            row(intArrayOf(1, 2, 3, 0, 0, 0), 3, intArrayOf(2, 5, 6), 3, intArrayOf(1, 2, 2, 3, 5, 6)),
            row(intArrayOf(1), 1, intArrayOf(), 0, intArrayOf(1)),
            row(intArrayOf(0), 0, intArrayOf(1), 1, intArrayOf(1)),
        ) { arr1, m, arr2, n, res ->
            merge(arr1, m, arr2, n).toList() shouldBe res.toList()
        }
    }
})
