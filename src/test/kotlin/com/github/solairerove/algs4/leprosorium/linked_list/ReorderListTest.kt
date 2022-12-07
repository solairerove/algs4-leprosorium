package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ReorderListTest : FunSpec({

    test("reorder list test case 1") {
        val head = ListNode(1).also {
            it.next = ListNode(2).also {
                it.next = ListNode(3).also {
                    it.next = ListNode(4)
                }
            }
        }

        reorderList(head)

        head.toList() shouldBe listOf(1, 4, 2, 3)
    }

    test("reorder list test case 2") {
        val head = ListNode(1).also {
            it.next = ListNode(2).also {
                it.next = ListNode(3).also {
                    it.next = ListNode(4).also {
                        it.next = ListNode(5)
                    }
                }
            }
        }

        reorderList(head)

        head.toList() shouldBe listOf(1, 5, 2, 4, 3)
    }
})
