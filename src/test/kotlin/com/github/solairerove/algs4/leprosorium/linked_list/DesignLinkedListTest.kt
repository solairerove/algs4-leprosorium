package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DesignLinkedListTest : FunSpec({

    test("design doubly linked list basic test") {
        val myLinkedList = MyDoublyLinkedList()
        myLinkedList.addAtHead(1)
        myLinkedList.addAtTail(3)
        myLinkedList.addAtIndex(1, 2)
        myLinkedList.get(1) shouldBe 2
        myLinkedList.deleteAtIndex(1)
        myLinkedList.get(1) shouldBe 3
    }

    test("design doubly linked list 63 test case") {
        val myLinkedList = MyDoublyLinkedList()
        myLinkedList.addAtIndex(1, 0)
        myLinkedList.get(0) shouldBe -1
    }

    test("design doubly linked list 40 test case") {
        val myLinkedList = MyDoublyLinkedList()
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

    test("design doubly linked list 27 test case") {
        val myLinkedList = MyDoublyLinkedList()
        myLinkedList.addAtHead(38)
        myLinkedList.addAtTail(66)
        myLinkedList.addAtTail(61)
        myLinkedList.addAtTail(76)
        myLinkedList.addAtTail(26)
        myLinkedList.addAtTail(37)
        myLinkedList.addAtTail(8)
        myLinkedList.deleteAtIndex(5)
        myLinkedList.addAtHead(4)
        myLinkedList.addAtHead(45)
        myLinkedList.get(4) shouldBe 61
        myLinkedList.addAtTail(85)
        myLinkedList.addAtHead(37)
        myLinkedList.get(5)
        myLinkedList.addAtTail(93)
        myLinkedList.addAtIndex(10, 23)
        myLinkedList.addAtTail(21)
        myLinkedList.addAtHead(52)
        myLinkedList.addAtHead(15)
        myLinkedList.addAtHead(47)
        myLinkedList.get(12)
        myLinkedList.addAtIndex(6, 24)
        myLinkedList.addAtHead(64)
        myLinkedList.get(4)
        myLinkedList.addAtHead(31)
        myLinkedList.deleteAtIndex(6)
        myLinkedList.addAtHead(40)
        myLinkedList.addAtTail(17)
        myLinkedList.addAtTail(15)
        myLinkedList.addAtIndex(19, 2)
        myLinkedList.addAtTail(11)
        myLinkedList.addAtHead(86)
        myLinkedList.get(17)
        myLinkedList.addAtTail(55)
        myLinkedList.deleteAtIndex(15)
        myLinkedList.addAtIndex(14, 95)
        myLinkedList.deleteAtIndex(22)
        myLinkedList.addAtHead(66)
        myLinkedList.addAtTail(95)
        myLinkedList.addAtHead(8)
        myLinkedList.addAtHead(47)
        myLinkedList.addAtTail(23)
        myLinkedList.addAtTail(39)
        myLinkedList.get(30)
        myLinkedList.get(27)
        myLinkedList.addAtHead(0)
        myLinkedList.addAtTail(99)
        myLinkedList.addAtTail(45)
        myLinkedList.addAtTail(4)
        myLinkedList.addAtIndex(9, 11)
        myLinkedList.get(6)
        myLinkedList.addAtHead(81)
        myLinkedList.addAtIndex(18,32)
        myLinkedList.addAtHead(20)
        myLinkedList.addAtTail(13)
        myLinkedList.addAtTail(42)
        myLinkedList.addAtIndex(37,91)
        myLinkedList.deleteAtIndex(36)
        myLinkedList.addAtIndex(10,37)
        myLinkedList.addAtHead(96)
        myLinkedList.addAtHead(57)
        myLinkedList.deleteAtIndex(20)
        myLinkedList.addAtTail(89)
        myLinkedList.deleteAtIndex(18)
        myLinkedList.addAtIndex(41,5)
        myLinkedList.addAtTail(23)
        myLinkedList.addAtHead(75)
        myLinkedList.get(7)
        myLinkedList.addAtIndex(25,51)
        myLinkedList.addAtTail(48)
        myLinkedList.addAtHead(46)
        myLinkedList.addAtHead(29)
        myLinkedList.addAtHead(85)
        myLinkedList.addAtHead(82)
        myLinkedList.addAtHead(6)
        myLinkedList.addAtHead(38)
        myLinkedList.deleteAtIndex(14)
        myLinkedList.get(1)
        myLinkedList.get(12)
        myLinkedList.addAtHead(42)
        myLinkedList.get(42)
        myLinkedList.addAtTail(83)
        myLinkedList.addAtTail(13)
        myLinkedList.addAtIndex(14,20)
        myLinkedList.addAtIndex(17,34)
        myLinkedList.addAtHead(36)
        myLinkedList.addAtTail(58)
        myLinkedList.addAtTail(2)
        myLinkedList.get(38)
        myLinkedList.addAtIndex(33,59)
        myLinkedList.addAtHead(37)
        myLinkedList.deleteAtIndex(15)
        myLinkedList.addAtTail(64)
        myLinkedList.get(56)
        myLinkedList.addAtHead(0)
        myLinkedList.get(40)
        myLinkedList.addAtHead(92)
        myLinkedList.deleteAtIndex(63)
        myLinkedList.get(35)
        myLinkedList.addAtTail(62)
        myLinkedList.addAtTail(32)
    }

    test("design singly linked list basic test") {
        val myLinkedList = MySinglyLinkedList()
        myLinkedList.addAtHead(1)
        myLinkedList.addAtTail(3)
        myLinkedList.addAtIndex(1, 2)
        myLinkedList.get(1) shouldBe 2
        myLinkedList.deleteAtIndex(1)
        myLinkedList.get(1) shouldBe 3
    }

    test("design singly linked list 63 test case") {
        val myLinkedList = MySinglyLinkedList()
        myLinkedList.addAtIndex(1, 0)
        myLinkedList.get(0) shouldBe -1
    }

    test("design singly linked list 40 test case") {
        val myLinkedList = MySinglyLinkedList()
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
