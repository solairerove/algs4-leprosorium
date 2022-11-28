package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class PalindromeLinkedListTest : StringSpec({
    "if the linked list is palindrome" {
        forAll(
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(2).also {
                            it.next = ListNode(1)
                        }
                    }
                }, true
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(2)
                }, false
            )
        ) { head, res ->
            isPalindrome(head) shouldBe res
            isPalindromeArray(head) shouldBe res
        }
    }
})
