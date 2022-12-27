package com.github.solairerove.algs4.leprosorium.microsoft

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MaximumDistanceBetweenTwoSameAdjacentTest : StringSpec({
    "maximum identical adjacent distance test" {
        forAll(
            row("aakmaakmakda", 7),
            row("aaa", 1),
            row("civic", -1),
            row("aa", -1),
            row("ab", -1),
            row("aba", -1),
            row("abab", 2),
            row("zabab", 2),
            row("zqabab", 2),
        ) { s, res ->
            maximumIdenticalAdjacentDistance(s) shouldBe res
        }
    }
})
