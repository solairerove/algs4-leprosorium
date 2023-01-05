package com.github.solairerove.algs4.leprosorium.hash_table

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class DesignTwitterTest : FunSpec({

    test("design twitter basic test") {
        val twitter = Twitter()
        // User 1 posts a new tweet (id = 5).
        twitter.postTweet(1, 5)

        // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.getNewsFeed(1) shouldBe listOf(5)

        // User 1 follows user 2.
        twitter.follow(1, 2)

        // User 2 posts a new tweet (id = 6).
        twitter.postTweet(2, 6)

        // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
        // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.getNewsFeed(1) shouldBe listOf(6, 5)

        // User 1 unfollows user 2.
        twitter.unfollow(1, 2)

        // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
        twitter.getNewsFeed(1) shouldBe listOf(5)
    }

    test("design twitter test case 7") {
        val twitter = Twitter()
        twitter.postTweet(1, 5)
        twitter.postTweet(1, 3)
        twitter.getNewsFeed(1) shouldBe listOf(3,5)
    }

    test("design twitter test case 11") {
        val twitter = Twitter()
        twitter.postTweet(1, 5)
        twitter.follow(1, 2)
        twitter.follow(2, 1)
        twitter.getNewsFeed(2) shouldBe listOf(5)
        twitter.postTweet(2, 6)
        twitter.getNewsFeed(1) shouldBe listOf(6, 5)
        twitter.getNewsFeed(2) shouldBe listOf(6, 5)
        twitter.unfollow(2, 1)
        twitter.getNewsFeed(1) shouldBe listOf(6, 5)
        twitter.getNewsFeed(2) shouldBe listOf(6)
        twitter.unfollow(1, 2)
        twitter.getNewsFeed(1) shouldBe listOf(5)
        twitter.getNewsFeed(2) shouldBe listOf(6)
    }
})
