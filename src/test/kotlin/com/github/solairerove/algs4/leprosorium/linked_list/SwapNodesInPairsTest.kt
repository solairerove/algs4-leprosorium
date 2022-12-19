package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class SwapNodesInPairsTest : StringSpec({
    "swap nodes in pair" {
        forAll(
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(4)
                        }
                    }
                }, listOf(2, 1, 4, 3)
            ),
            row(
                null, null
            ),
            row(
                ListNode(1), listOf(1)
            )
        ) { head, res ->
            swapPairs(head)?.toList() shouldBe res
        }
    }
})
