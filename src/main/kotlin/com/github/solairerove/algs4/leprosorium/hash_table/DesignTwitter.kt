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
    }

    fun follow(followerId: Int, followeeId: Int) {
        if (!users.containsKey(followerId)) users[followerId] = User(followerId)
        if (!users.containsKey(followeeId)) users[followeeId] = User(followeeId)

        users[followerId]!!.addFollower(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        if (followerId != followeeId) users[followerId]?.removeFollower(followeeId)
    }
}
