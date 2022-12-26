package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DesignHashMapTest : FunSpec({

    test("design hash map basic test") {
        val hm = MyHashMap()
        hm.put(1, 2)
        hm.put(2, 1)
        hm.put(20, 1)
        hm.get(1) shouldBe 2
        hm.get(2) shouldBe 1
        hm.remove(2)
        hm.get(2) shouldBe -1
    }
})
