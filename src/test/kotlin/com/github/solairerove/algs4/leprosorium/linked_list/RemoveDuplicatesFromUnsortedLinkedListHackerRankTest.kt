package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RemoveDuplicatesFromUnsortedLinkedListHackerRankTest: StringSpec({
    "remove duplicated from unsorted linked list hacker rank" {
        forAll(
            row(
                ListNode(2).also {
                    it.next = ListNode(1).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(1).also {
                                it.next = ListNode(4).also {
                                    it.next = ListNode(2).also {
                                        it.next = ListNode(3)
                                    }
                                }
                            }
                        }
                    }
                }, listOf(2, 1, 3, 4)
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
            deleteDuplicatesUnsorted(head)?.toList() shouldBe res
        }
    }
})