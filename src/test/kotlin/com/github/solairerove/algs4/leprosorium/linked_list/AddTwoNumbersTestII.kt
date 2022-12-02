package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class AddTwoNumbersTestII : StringSpec({
    "add two numbers ii" {
        forAll(
            row(
                ListNode(7).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(4).also {
                            it.next = ListNode(3)
                        }
                    }
                },
                ListNode(5).also {
                    it.next = ListNode(6).also {
                        it.next = ListNode(4)
                    }
                }, listOf(7, 8, 0, 7)
            ),
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
                }, listOf(8, 0, 7)
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
                }, listOf(1, 0, 0, 0, 9, 9, 9, 8)
            ),
        ) { list1, list2, res ->
            addTwoNumbersIIReverse(list1, list2)?.toList() shouldBe res
        }
    }
})
