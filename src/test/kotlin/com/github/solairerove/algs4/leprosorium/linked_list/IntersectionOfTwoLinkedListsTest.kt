package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class IntersectionOfTwoLinkedListsTest : StringSpec({
    val intersection1 = ListNode(8)
    val intersection2 = ListNode(2)
    "intersection of two linked lists" {
        forAll(
            row(
                ListNode(4).also {
                    it.next = ListNode(1).also {
                        it.next = intersection1.also {
                            it.next = ListNode(4).also {
                                it.next = ListNode(5)
                            }
                        }
                    }
                },
                ListNode(5).also {
                    it.next = ListNode(6).also {
                        it.next = ListNode(1).also {
                            it.next = intersection1.also {
                                it.next = ListNode(4).also {
                                    it.next = ListNode(5)
                                }
                            }
                        }
                    }
                },
                intersection1
            ),
            row(
                ListNode(1).also {
                    it.next = ListNode(9).also {
                        it.next = ListNode(1).also {
                            it.next = intersection2.also {
                                it.next = ListNode(4)
                            }
                        }
                    }
                },
                ListNode(3).also {
                    it.next = intersection2.also {
                        it.next = ListNode(4)
                    }
                },
                intersection2
            ),
            row(
                ListNode(2).also {
                    it.next = ListNode(6).also {
                        it.next = ListNode(4)
                    }
                },
                ListNode(1).also {
                    it.next = ListNode(5)
                },
                null
            ),
        ) { head1, head2, res ->
            getIntersectionNode(head1, head2) shouldBe res
            getIntersectionNodeSet(head1, head2) shouldBe res
        }
    }
})
