package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ReverseNodesInEvenLengthGroupsTest : StringSpec({
    "reverse nodes in even lengths groups test" {
        forAll(
            row(
                ListNode(5).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(6).also {
                            it.next = ListNode(3).also {
                                it.next = ListNode(9).also {
                                    it.next = ListNode(1).also {
                                        it.next = ListNode(7).also {
                                            it.next = ListNode(3).also {
                                                it.next = ListNode(8).also {
                                                    it.next = ListNode(4)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }, listOf(5, 6, 2, 3, 9, 1, 4, 8, 3, 7)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(1).also {
                        it.next = ListNode(0).also {
                            it.next = ListNode(6)
                        }
                    }
                }, listOf(1, 0, 1, 6)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(1).also {
                        it.next = ListNode(0).also {
                            it.next = ListNode(6).also {
                                it.next = ListNode(5)
                            }
                        }
                    }
                }, listOf(1, 0, 1, 5, 6)
            ),
        ) { head, res ->
            reverseEvenLengthGroups(head)?.toList() shouldBe res
        }
    }
})
