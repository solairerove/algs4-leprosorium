package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class SwappingNodesInALinkedListTest : StringSpec({
    "swapping node is a linked list" {
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
                }, 2, listOf(1, 4, 3, 2, 5)
            ),
            row(
                ListNode(7).also {
                    it.next = ListNode(9).also {
                        it.next = ListNode(6).also {
                            it.next = ListNode(6).also {
                                it.next = ListNode(7).also {
                                    it.next = ListNode(8).also {
                                        it.next = ListNode(3).also {
                                            it.next = ListNode(0).also {
                                                it.next = ListNode(9).also {
                                                    it.next = ListNode(5)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }, 5, listOf(7, 9, 6, 6, 8, 7, 3, 0, 9, 5)
            )
        ) { head, k, res ->
            swapNodes(head, k)?.toList() shouldBe res
        }
    }
})
