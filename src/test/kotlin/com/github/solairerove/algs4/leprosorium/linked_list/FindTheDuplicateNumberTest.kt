package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class FindTheDuplicateNumberTest : StringSpec({
    "find the duplicate number test" {
        forAll(
            row(intArrayOf(1, 3, 4, 2, 2), 2),
            row(intArrayOf(3, 1, 3, 4, 2), 3)
        ) { nums, res ->
            findDuplicate(nums) shouldBe res
        }
    }
})
