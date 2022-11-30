package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RemoveNthNodeFromEndOfListTest : StringSpec({
    "remove nth node from end of list" {
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
                }, 2, listOf(1, 2, 3, 5)
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
                }, 4, listOf(1, 3, 4, 5)
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
                }, 5, listOf(2, 3, 4, 5)
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
                }, 1, listOf(1, 2, 3, 4)
            ),
            row(
                ListNode(1), 1, null
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(2)
                }, 1, listOf(1)
            ),
        ) { list, n, res ->
            removeNthFromEnd(list, n)?.toList() shouldBe res
        }
    }
})
