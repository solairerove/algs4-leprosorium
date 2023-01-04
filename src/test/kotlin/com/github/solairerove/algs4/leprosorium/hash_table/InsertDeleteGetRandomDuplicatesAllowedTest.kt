package com.github.solairerove.algs4.leprosorium.hash_table

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class InsertDeleteGetRandomDuplicatesAllowedTest : FunSpec({

    test("insert delete get random duplicates allowed O(1) basic test") {
        val randomizedCollection = RandomizedCollection()
        randomizedCollection.insert(1) shouldBe true // return true since the collection does not contain 1.
        // Inserts 1 into the collection.
        randomizedCollection.insert(1) shouldBe false // return false since the collection contains 1.
        // Inserts another 1 into the collection. Collection now contains [1,1].
        randomizedCollection.insert(2) shouldBe true // return true since the collection does not contain 2.
        // Inserts 2 into the collection. Collection now contains [1,1,2].
        listOf(1, 2).contains(randomizedCollection.getRandom()) shouldBe true // getRandom should:
        // - return 1 with probability 2/3, or
        // - return 2 with probability 1/3.
        randomizedCollection.remove(1) shouldBe true // return true since the collection contains 1.
        // Removes 1 from the collection. Collection now contains [1,2].
        listOf(
            1,
            2
        ).contains(randomizedCollection.getRandom()) shouldBe true // getRandom should return 1 or 2, both equally likely.

    }
})
