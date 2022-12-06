package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DesignLinkedListTest : FunSpec({

    test("design linked list basic test") {
        val myLinkedList = MyLinkedList()
        myLinkedList.addAtHead(1)
        myLinkedList.addAtTail(3)
        myLinkedList.addAtIndex(1, 2)
        myLinkedList.get(1) shouldBe 2
        myLinkedList.deleteAtIndex(1)
        myLinkedList.get(1) shouldBe 3
    }

    test("design linked list 63 test case") {
        val myLinkedList = MyLinkedList()
        myLinkedList.addAtIndex(1, 0)
        myLinkedList.get(0) shouldBe -1
    }

    test("design linked list 40 test case") {
        val myLinkedList = MyLinkedList()
        myLinkedList.addAtHead(2)
        myLinkedList.deleteAtIndex(1)
        myLinkedList.addAtHead(2)
        myLinkedList.addAtHead(7)
        myLinkedList.addAtHead(3)
        myLinkedList.addAtHead(2)
        myLinkedList.addAtHead(5)
        myLinkedList.addAtTail(5)
        myLinkedList.get(5) shouldBe 2
        myLinkedList.deleteAtIndex(6)
        myLinkedList.deleteAtIndex(4)
    }
})
