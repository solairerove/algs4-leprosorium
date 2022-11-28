package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class OddEvenLinkedListTest : StringSpec({
    "odd event linked list" {
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
                }, listOf(1, 3, 5, 2, 4)
            ),
            row(
                ListNode(2).also {
                    it.next = ListNode(1).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(5).also {
                                it.next = ListNode(6).also {
                                    it.next = ListNode(4).also {
                                        it.next = ListNode(7)
                                    }
                                }
                            }
                        }
                    }
                }, listOf(2, 3, 6, 7, 1, 5, 4)
            ),
        ) { head, res ->
            oddEvenList(head)?.toList() shouldBe res
        }
    }
})
