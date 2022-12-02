package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class DeleteNodeInALinkedListTest : StringSpec({
    val node1 = ListNode(5)
    val head1 = ListNode(4).also {
        it.next = node1.also {
            it.next = ListNode(1).also {
                it.next = ListNode(9)
            }
        }
    }

    val node2 = ListNode(1)
    val head2 = ListNode(4).also {
        it.next = ListNode(5).also {
            it.next = node2.also {
                it.next = ListNode(9)
            }
        }
    }
    "delete node in a linked list" {
        forAll(
            row(node1, listOf(4, 1, 9)),
        ) { node, res ->
            deleteNode(node)
            head1.toList() shouldBe res
        }
        forAll(
            row(node2, listOf(4, 5, 9)),
        ) { node, res ->
            deleteNode(node)
            head2.toList() shouldBe res
        }
    }
})
