package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class PartitionListTest : StringSpec({
    "partition linked list test" {
        forAll(
            row(
                ListNode(1).also {
                    it.next = ListNode(4).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(2).also {
                                it.next = ListNode(5).also {
                                    it.next = ListNode(2)
                                }
                            }
                        }
                    }
                }, 3, listOf(1, 2, 2, 4, 3, 5)
            ),
            row(
                ListNode(2).also {
                    it.next = ListNode(1)
                }, 2, listOf(1, 2)
            ),
        ) { head, x, res ->
            partition(head, x)?.toList() shouldBe res
        }
    }
})
