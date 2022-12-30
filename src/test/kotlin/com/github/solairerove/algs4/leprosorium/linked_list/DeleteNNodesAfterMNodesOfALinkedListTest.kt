package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class DeleteNNodesAfterMNodesOfALinkedListTest : StringSpec({
    "delete n nodes after m nodes of a linled list test" {
        forAll(
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(4).also {
                                it.next = ListNode(5).also {
                                    it.next = ListNode(6).also {
                                        it.next = ListNode(7).also {
                                            it.next = ListNode(8).also {
                                                it.next = ListNode(9).also {
                                                    it.next = ListNode(10).also {
                                                        it.next = ListNode(11).also {
                                                            it.next = ListNode(12).also {
                                                                it.next = ListNode(13)
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                },
                2, 3, listOf(1, 2, 6, 7, 11, 12)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(4).also {
                                it.next = ListNode(5).also {
                                    it.next = ListNode(6).also {
                                        it.next = ListNode(7).also {
                                            it.next = ListNode(8).also {
                                                it.next = ListNode(9).also {
                                                    it.next = ListNode(10).also {
                                                        it.next = ListNode(11)
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                },
                1, 3, listOf(1, 5, 9)
            ),
        ) { head, m, n, res ->
            deleteNodes(head, m, n)?.toList() shouldBe res
        }
    }
})
