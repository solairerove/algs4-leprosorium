package com.github.solairerove.algs4.leprosorium.hash_table

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

    test("design hash map basic leetcode test") {
        val myHashMap = MyHashMap()
        myHashMap.put(1, 1) // The map is now [[1,1]]
        myHashMap.put(2, 2) // The map is now [[1,1], [2,2]]
        myHashMap.get(1) shouldBe 1 // return 1, The map is now [[1,1], [2,2]]
        myHashMap.get(3) shouldBe -1 // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1) // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2) shouldBe 1 // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2) // remove the mapping for 2, The map is now [[1,1]]
        myHashMap.get(2) shouldBe -1 // return -1 (i.e., not found), The map is now [[1,1]]
    }
})
