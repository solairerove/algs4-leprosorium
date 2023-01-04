package com.github.solairerove.algs4.leprosorium.hash_table

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class InsertDeleteGetRandomTest : FunSpec({

    test("insert delete get random O(1) basic test") {
        val randomizedSet = RandomizedSet()
        randomizedSet.insert(1) shouldBe true // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomizedSet.remove(2) shouldBe false // Returns false as 2 does not exist in the set.
        randomizedSet.insert(2) shouldBe true // Inserts 2 to the set, returns true. Set now contains [1,2].
        listOf(
            1,
            2
        ).contains(randomizedSet.getRandom()) shouldBe true  // getRandom() should return either 1 or 2 randomly.
        randomizedSet.remove(1) shouldBe true // Removes 1 from the set, returns true. Set now contains [2].
        randomizedSet.insert(2) shouldBe false // 2 was already in the set, so return false.
        randomizedSet.getRandom() shouldBe 2 // Since 2 is the only number in the set, getRandom() will always return 2.
    }
})
