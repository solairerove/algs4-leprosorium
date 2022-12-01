package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class AddTwoNumbersTest : StringSpec({
    "add two numbers" {
        forAll(
            row(
                ListNode(2).also {
                    it.next = ListNode(4).also {
                        it.next = ListNode(3)
                    }
                },
                ListNode(5).also {
                    it.next = ListNode(6).also {
                        it.next = ListNode(4)
                    }
                }, listOf(7, 0, 8)
            ),
            row(
                ListNode(0), ListNode(0), listOf(0)
            ),
            row(
                ListNode(9).also {
                    it.next = ListNode(9).also {
                        it.next = ListNode(9).also {
                            it.next = ListNode(9).also {
                                it.next = ListNode(9).also {
                                    it.next = ListNode(9).also {
                                        it.next = ListNode(9)
                                    }
                                }
                            }
                        }
                    }
                },
                ListNode(9).also {
                    it.next = ListNode(9).also {
                        it.next = ListNode(9).also {
                            it.next = ListNode(9)
                        }
                    }
                }, listOf(8, 9, 9, 9, 0, 0, 0, 1)
            ),
        ) { list1, list2, res ->
            addTwoNumbers(list1, list2)?.toList() shouldBe res
        }
    }
})
