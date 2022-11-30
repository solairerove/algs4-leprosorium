package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MiddleOfTheLinkedListTest : StringSpec({
    "middle of the linked list" {
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
                }, listOf(3, 4, 5)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(4).also {
                                it.next = ListNode(5).also {
                                    it.next = ListNode(6)
                                }
                            }
                        }
                    }
                }, listOf(4, 5, 6)
            )
        ) { list, res ->
            middleNode(list)?.toList() shouldBe res
        }
    }
})
