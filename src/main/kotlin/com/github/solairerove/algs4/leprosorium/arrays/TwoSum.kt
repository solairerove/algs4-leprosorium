package com.github.solairerove.algs4.leprosorium.arrays

/**
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Input: nums = [2, 7, 11, 15], target = 9
 * Output: [0, 1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */

// O(n) time | O(n) space
fun twoSum(nums: IntArray, target: Int): IntArray {
    val hm = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        val toFind = target - nums[i]
        if (hm.containsKey(toFind)) {
            return intArrayOf(i, hm[toFind]!!)
        } else {
            hm[nums[i]] = i
        }
    }

    return intArrayOf()
}
