package com.github.solairerove.algs4.leprosorium.linked_list

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LFUCacheTest : FunSpec({

    test("design lfu cache basic test") {
        val lfu = LFUCache(2)
        lfu.put(1, 1) // cache=[1,_], cnt(1)=1
        lfu.put(2, 2) // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1) shouldBe 1 // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3) // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2) shouldBe -1 // return -1 (not found)
        lfu.get(3) shouldBe 3 // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4) // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1) shouldBe -1 // return -1 (not found)
        lfu.get(3) shouldBe 3 // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4) shouldBe 4 // return 4
        // cache=[4,3], cnt(4)=2, cnt(3)=3
    }
})
