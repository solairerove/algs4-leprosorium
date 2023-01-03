package com.github.solairerove.algs4.leprosorium.hash_table

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DesignHashSetTest : FunSpec({

    test("design hash set basic test") {
        val hs = MyHashSet()
        hs.add(1)
        hs.add(2)
        hs.contains(2) shouldBe true
        hs.contains(3) shouldBe false
        hs.remove(2)
        hs.contains(2) shouldBe false
    }

    test("design hash set basic leetcode test") {
        val myHashSet = MyHashSet()
        myHashSet.add(1) // set = [1]
        myHashSet.add(2) // set = [1, 2]
        myHashSet.contains(1) shouldBe true // return True
        myHashSet.contains(3) shouldBe false // return False, (not found)
        myHashSet.add(2) // set = [1, 2]
        myHashSet.contains(2) shouldBe true// return True
        myHashSet.remove(2) // set = [1]
        myHashSet.contains(2) shouldBe false// return False, (already removed)
    }
})
