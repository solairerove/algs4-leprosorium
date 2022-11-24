package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LinkedListCycleTest : StringSpec({
    val cycle = ListNode(2)
    "if the linked list has a cycle in it" {
        forAll(
            row(
                ListNode(3).also {
                    it.next = cycle.also {
                        it.next = ListNode(0).also {
                            it.next = ListNode(-4).also {
                                it.next = cycle
                            }
                        }
                    }
                }, true
            ),
            row(
                ListNode(1).also {
                    it.next = cycle.also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(4).also {
                                it.next = ListNode(5).also {
                                    it.next = cycle
                                }
                            }
                        }
                    }
                }, true
            ),
            row(
                cycle.also {
                    it.next = ListNode(1).also {
                        it.next = cycle
                    }
                }, true
            ),
            row(
                ListNode(1), false
            ),
            row(
                null, false
            )
        ) { head, res ->
            hasCycle(head) shouldBe res
        }
    }
})
