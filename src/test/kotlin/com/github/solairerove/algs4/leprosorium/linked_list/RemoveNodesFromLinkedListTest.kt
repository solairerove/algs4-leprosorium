package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class RemoveNodesFromLinkedListTest : StringSpec({
    "remove nodes from linked list test" {
        forAll(
            row(
                ListNode(5).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(13).also {
                            it.next = ListNode(3).also {
                                it.next = ListNode(8)
                            }
                        }
                    }
                }, listOf(13, 8)
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(1).also {
                        it.next = ListNode(1).also {
                            it.next = ListNode(1)
                        }
                    }
                }, listOf(1, 1, 1, 1)
            ),
        ) { head, res ->
            removeNodes(head)?.toList() shouldBe res
        }
    }
})
