package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RotateListTest : StringSpec({
    "rotate linked list right" {
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
                }, 2, listOf(4, 5, 1, 2, 3)
            ),
            row(
                ListNode(0).also {
                    it.next = ListNode(1).also {
                        it.next = ListNode(2)
                    }
                }, 4, listOf(2, 0, 1)
            ),
        ) { head, k, res ->
            rotateRight(head, k)?.toList() shouldBe res
        }
    }
})
