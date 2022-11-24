package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LinkedListCycleIITest : StringSpec({
    val cycle = ListNode(2)
    "linked list cycle II" {
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
                }, cycle
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
                }, cycle
            ),
            row(
                cycle.also {
                    it.next = ListNode(1).also {
                        it.next = cycle
                    }
                }, cycle
            ),
            row(
                ListNode(1), null
            ),
            row(
                null, null
            )
        ) { head, res ->
            detectCycle(head) shouldBe res
        }
    }
})
