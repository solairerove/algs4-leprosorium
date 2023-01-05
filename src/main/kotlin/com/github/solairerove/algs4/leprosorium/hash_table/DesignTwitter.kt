package com.github.solairerove.algs4.leprosorium.hash_table

import java.util.*


/**
 * Design a simplified version of Twitter
 * where users can post tweets, follow/unfollow another user,
 * and is able to see the 10 most recent tweets in the user's news feed.
 *
 * Implement the Twitter class:
 *
 * Twitter() Initializes your twitter object.
 *
 * void postTweet(int userId, int tweetId)
 * Composes a new tweet with ID tweetId by the user userId.
 * Each call to this function will be made with a unique tweetId.
 *
 * List<Integer> getNewsFeed(int userId)
 * Retrieves the 10 most recent tweet IDs in the user's news feed.
 * Each item in the news feed must be posted by users who the user followed or by the user themself.
 * Tweets must be ordered from most recent to least recent.
 *
 * void follow(int followerId, int followeeId)
 * The user with ID followerId started following the user with ID followeeId.
 *
 * void unfollow(int followerId, int followeeId)
 * The user with ID followerId started unfollowing the user with ID followeeId.
 */
const val FEED_SIZE = 10

class Twitter {
    private var time = 0
    private val users = mutableMapOf<Int, User>() // user id to user to fast

    private class User(userId: Int) {
        val followers: MutableSet<Int> = mutableSetOf() // user id to hash set of followers
        var tweets: Tweet? = null // user id to tweets linked list, removeLast if size > 10

        init {
            followers.add(userId)
        }

        fun addFollower(userId: Int) = followers.add(userId)

        fun removeFollower(userId: Int) = followers.remove(userId)

        fun addTweet(tweetId: Int, time: Int) {
            val node = Tweet(tweetId, time)
            if (tweets == null) tweets = node
            else {
                node.next = tweets
                tweets = node
            }
        }
    }

    private data class Tweet(val tweetId: Int, val time: Int, var next: Tweet? = null)

    fun postTweet(userId: Int, tweetId: Int) {
        if (!users.containsKey(userId)) users[userId] = User(userId)

        users[userId]!!.addTweet(tweetId, ++time)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        if (!users.containsKey(userId)) return listOf()

        val res: MutableList<Int> = LinkedList()
        val followers: MutableSet<Int> = users[userId]!!.followers

        val q = PriorityQueue(users.size) { el1: Tweet, el2: Tweet -> el2.time - el1.time }
        for (user in followers) {
            val t = users[user]!!.tweets
            if (t != null) {
                q.add(t)
            }
        }
        var i = FEED_SIZE
        while (!q.isEmpty() && i-- > 0) {
            val tweet = q.poll()
            res.add(tweet.tweetId)

            if (tweet.next != null) q.add(tweet.next)
        }

        return res
//        if (!users.containsKey(userId)) return listOf()
//
//        val feedToSort: Array<TweetNode?> = users[userId]!!.followers.mapNotNull { users[it]!!.tweets }.toTypedArray()
//
//        val sortedFeed = mergeKLists(feedToSort)
//
//        val feed = mutableListOf<Int>()
//        var curr = sortedFeed
//        var i = FEED_SIZE
//        while (curr != null && i-- > 0) {
//            feed.add(curr.tweet.tweetId)
//            curr = curr.next
//        }
//
//        return feed
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (!users.containsKey(followerId)) users[followerId] = User(followerId)
        if (!users.containsKey(followeeId)) users[followeeId] = User(followeeId)

        users[followerId]!!.addFollower(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        if (followerId != followeeId) users[followerId]?.removeFollower(followeeId)
    }

    // peek 10?
//    private fun mergeKLists(lists: Array<TweetNode?>): TweetNode? {
//        if (lists.isEmpty()) return null
//        if (lists.size == 1) return lists[0]
//
//        var interval = 1
//        while (interval < lists.size) {
//            var i = 0
//            while (i + interval < lists.size) {
//                lists[i] = mergeTwoLists(lists[i], lists[i + interval])
//                i += interval * 2
//            }
//            interval *= 2
//        }
//
//        return lists[0]
//    }
//
//    private fun mergeTwoLists(list1: TweetNode?, list2: TweetNode?): TweetNode? {
//        if (list1 == null) return list2
//        if (list2 == null) return list1
//
//        val sentinel = TweetNode(Tweet(-1, 0))
//        var prev: TweetNode? = sentinel
//
//        var curr1: TweetNode? = list1
//        var curr2: TweetNode? = list2
//        while (curr1 != null && curr2 != null) {
//            if (curr1.tweet.time > curr2.tweet.time) {
//                prev?.next = curr1
//                curr1 = curr1.next
//            } else {
//                prev?.next = curr2
//                curr2 = curr2.next
//            }
//
//            prev = prev?.next
//        }
//
//        prev?.next = curr1 ?: curr2
//
//        return sentinel.next
//    }
}
