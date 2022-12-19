package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ReverseNodesInKGroupTest : StringSpec({
    "reverse nodes in k group test" {
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
                }, 2, listOf(2, 1, 4, 3, 5)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(4).also {
                                it.next = ListNode(5)
                            }
                        }
                    }
                }, 3, listOf(3, 2, 1, 4, 5)
            ),
        ) { head, k, res ->
            reverseKGroup(head, k)?.toList() shouldBe res
        }
    }
})
