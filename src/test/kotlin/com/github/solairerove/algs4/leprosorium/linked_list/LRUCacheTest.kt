package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LRUCacheTest : FunSpec({

    test("design lru cache basic test") {
        val lRUCache = LRUCache(2)
        lRUCache.put(1, 1) // cache is {1=1}
        lRUCache.put(2, 2) // cache is {1=1, 2=2}
        lRUCache.get(1) shouldBe 1 // return 1
        lRUCache.put(3, 3) // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2) shouldBe -1 // returns -1 (not found)
        lRUCache.put(4, 4) // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1) shouldBe -1 // return -1 (not found)
        lRUCache.get(3) shouldBe 3 // return 3
        lRUCache.get(4) shouldBe 4 // return 4
    }
})
