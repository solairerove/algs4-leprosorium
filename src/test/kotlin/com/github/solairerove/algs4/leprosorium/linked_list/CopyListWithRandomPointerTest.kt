package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class CopyListWithRandomPointerTest : FunSpec({

    test("copy list with random pointer basic test") {
        val head = RListNode(7)
        val node1 = RListNode(13)
        val node2 = RListNode(11)
        val node3 = RListNode(10)
        val node4 = RListNode(1)

        head.next = node1
        node1.next = node2
        node2.next = node3
        node3.next = node4

        node1.random = head
        node2.random = node4
        node3.random = node2
        node4.random = head

        val actual = copyRandomListRecursive(head)!!

        actual.toList() shouldBe listOf(7, 13, 11, 10, 1)
        actual.next!!.random shouldBe actual
    }
})
