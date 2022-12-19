package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class InsertIntoASortedCircularLinkedListTest : FunSpec({

    test("insert into a sorted circular linked list test case 1") {
        val head = ListNode(3)
        val node1 = ListNode(4)
        val node2 = ListNode(1)

        head.next = node1
        node1.next = node2

        node2.next = head

        val res = insert(head, 2)
        res.value shouldBe 3
        res.next?.value shouldBe 4
        res.next?.next?.value shouldBe 1
        res.next?.next?.next?.value shouldBe 2
        res.next?.next?.next?.next?.value shouldBe 3
    }

    test("insert into a sorted circular linked list test case 2") {
        insert(null, 1).value shouldBe 1
    }
})
