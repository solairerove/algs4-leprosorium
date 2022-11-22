package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RemoveDuplicatesFromSortedLinkedListIITest : StringSpec({
    "remove duplicates from sorted linked list II" {
        forAll(
            row(
                ListNode(1).also {
                    it.next = ListNode(1).also {
                        it.next = ListNode(1).also {
                            it.next = ListNode(2).also {
                                it.next = ListNode(2).also {
                                    it.next = ListNode(3).also {
                                        it.next = ListNode(4)
                                    }
                                }
                            }
                        }
                    }
                }, listOf(3, 4)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(3).also {
                                it.next = ListNode(4).also {
                                    it.next = ListNode(4).also {
                                        it.next = ListNode(5)
                                    }
                                }
                            }
                        }
                    }
                }, listOf(1, 2, 5)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(2)
                }, listOf(1, 2)
            ),
            row(
                ListNode(1), listOf(1)
            ),
            row(
                null, null
            )
        ) { head, res ->
            deleteDuplicatesDFSFromSortedII(head)?.toList() shouldBe res
        }
    }
})
