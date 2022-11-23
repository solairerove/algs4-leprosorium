package com.github.solairerove.algs4.leprosorium.strings

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ValidPalindromeTest : StringSpec({
    "valid palindrome" {
        forAll(
            row("A man, a plan, a canal: Panama", true),
            row("race a car", false),
            row("racecar", true),
            row("civic", true),
            row(" ", true),
        ) { s, res ->
            isPalindrome(s) shouldBe res
        }
    }
})
