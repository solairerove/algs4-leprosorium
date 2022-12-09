package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FlattenAMultilevelDoublyLinkedListTest : FunSpec({

    test("flatten a multilevel doubly linked list") {
        val root = DListNode(1)
        val node2 = DListNode(2)
        val node3 = DListNode(3)
        val node4 = DListNode(4)
        val node5 = DListNode(5)
        val node6 = DListNode(6)
        root.next = node2
        node2.next = node3
        node3.next = node4
        node4.next = node5
        node5.next = node6
        node2.prev = root
        node3.prev = node2
        node4.prev = node3
        node5.prev = node4
        node6.prev = node5

        val node7 = DListNode(7)
        val node8 = DListNode(8)
        val node9 = DListNode(9)
        val node10 = DListNode(10)
        node7.next = node8
        node8.next = node9
        node9.next = node10
        node8.prev = node7
        node9.prev = node8
        node10.prev = node9

        val node11 = DListNode(11)
        val node12 = DListNode(12)
        node11.next = node12
        node12.prev = node11

        node3.child = node7
        node8.child = node11

        flatten(root)?.toList() shouldBe listOf(1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6)
    }
})
