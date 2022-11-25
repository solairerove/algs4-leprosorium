package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ReverseLinkedListTestII : StringSpec({
    "reverse linked list II" {
        forAll(
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(4).also {
                                it.next = ListNode(5)
                            }
                        }
                    }
                }, 2, 4, listOf(1, 4, 3, 2, 5)
            ),
            row(
                ListNode(5), 1, 1, listOf(5)
            )
        ) { head, left, right, res ->
            reverseBetween(head, left, right)?.toList() shouldBe res
        }
    }
})
