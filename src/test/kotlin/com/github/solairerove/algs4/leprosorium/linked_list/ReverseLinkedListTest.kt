package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class ReverseLinkedListTest : StringSpec({
    "reverse linked list" {
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
                }, listOf(5, 4, 3, 2, 1)
            )
        ) { head, res ->
            reverseList(head)?.toList() shouldBe res
        }
    }
})
