package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LinkedListRandomNodeTest : FunSpec({

    test("linked list random node basic test") {
        val head = ListNode(1).also {
            it.next = ListNode(2).also {
                it.next = ListNode(3)
            }
        }
        val linkedListRandomNode = LinkedListRandomNodeUsingArray(head);
        listOf(1, 2, 3).contains(linkedListRandomNode.getRandom()) shouldBe true  // return 1
        listOf(1, 2, 3).contains(linkedListRandomNode.getRandom()) shouldBe true  // return 3
        listOf(1, 2, 3).contains(linkedListRandomNode.getRandom()) shouldBe true  // return 2
        listOf(1, 2, 3).contains(linkedListRandomNode.getRandom()) shouldBe true  // return 2
        listOf(1, 2, 3).contains(linkedListRandomNode.getRandom()) shouldBe true  // return 3
        // getRandom() should return either 1, 2, or 3 randomly.
        // Each element should have equal probability of returning.
    }
})
