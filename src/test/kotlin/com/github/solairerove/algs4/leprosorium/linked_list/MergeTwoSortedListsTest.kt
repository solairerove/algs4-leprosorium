package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MergeTwoSortedListsTest : StringSpec({
    "merge two sorted lists" {
        forAll(
            row(
                ListNode(1).also {
                    it.next = ListNode(2).also {
                        it.next = ListNode(4)
                    }
                },
                ListNode(1).also {
                    it.next = ListNode(3).also {
                        it.next = ListNode(4)
                    }
                }, listOf(1, 1, 2, 3, 4, 4)
            ),
            row(
                null, null, null
            ),
            row(
                null, ListNode(0), listOf(0)
            ),
            row(
                ListNode(2), ListNode(1), listOf(1, 2)
            )
        ) { list1, list2, res ->
            mergeTwoLists(list1, list2)?.toList() shouldBe res
        }
    }
})
