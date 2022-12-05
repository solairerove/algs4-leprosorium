package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class MergeKSortedListsTest : StringSpec({
    "merge k sorted lists" {
        forAll(
            row(
                arrayOf<ListNode?>(
                    ListNode(1).also {
                        it.next = ListNode(4).also {
                            it.next = ListNode(5)
                        }
                    },
                    ListNode(1).also {
                        it.next = ListNode(3).also {
                            it.next = ListNode(4)
                        }
                    },
                    ListNode(2).also {
                        it.next = ListNode(6)
                    }
                ), listOf(1, 1, 2, 3, 4, 4, 5, 6)
            ),
            row(
                arrayOf(), null
            )
        ) { lists, res ->
            mergeKListsNaive(lists)?.toList() shouldBe res
        }
    }
})
