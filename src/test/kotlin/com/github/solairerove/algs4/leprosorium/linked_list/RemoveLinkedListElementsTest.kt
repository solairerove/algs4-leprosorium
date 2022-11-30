package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RemoveLinkedListElementsTest : StringSpec({
    "remove linked list elements" {
        forAll(
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(6).also {
                            it.next = ListNode(3).also {
                                it.next = ListNode(4).also {
                                    it.next = ListNode(5).also {
                                        it.next = ListNode(6)
                                    }
                                }
                            }
                        }
                    }
                }, 6, listOf(1, 2, 3, 4, 5)
            ),
            row(
                null, 1, null
            ),
            row(
                ListNode(7).also {
                    it.next = ListNode(7).also {
                        it.next = ListNode(7).also {
                            it.next = ListNode(7)
                        }
                    }
                }, 7, null
            ),
        ) { head, value, res ->
            removeElements(head, value)?.toList() shouldBe res
        }
    }
})
