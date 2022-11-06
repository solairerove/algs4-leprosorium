package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RemoveOddFromLinkedListTest : StringSpec({
    "remove odd from linked list" {
        forAll(
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(4)
                        }
                    }
                }, listOf(2, 4)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(4).also {
                            it.next = ListNode(3)
                        }
                    }
                }, listOf(2, 4)
            ),
            row(
                ListNode(2).also {
                    it.next = ListNode(1).also {
                        it.next = ListNode(4).also {
                            it.next = ListNode(3)
                        }
                    }
                }, listOf(2, 4)
            ),
            row(
                ListNode(2).also {
                    it.next = ListNode(1).also {
                        it.next = ListNode(1).also {
                            it.next = ListNode(4)
                        }
                    }
                }, listOf(2, 4)
            ),
            row(
                ListNode(2).also {
                    it.next = ListNode(4).also {
                        it.next = ListNode(6).also {
                            it.next = ListNode(1)
                        }
                    }
                }, listOf(2, 4, 6)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(4).also {
                            it.next = ListNode(6)
                        }
                    }
                }, listOf(2, 4, 6)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(4).also {
                            it.next = ListNode(1)
                        }
                    }
                }, listOf(2, 4)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(1).also {
                        it.next = ListNode(1).also {
                            it.next = ListNode(1)
                        }
                    }
                }, null
            )
        ) { head, res ->
            deleteOdd(head)?.toList() shouldBe res
        }
    }
})
