package com.github.solairerove.algs4.leprosorium.dynamic_programming

/**
 * You are given two arrays of integers nums1 and nums2, possibly of different lengths.
 * The values in the arrays are between 1 and 6, inclusive.
 *
 * In one operation, you can change any integer's value in any of the arrays to any value between 1 and 6, inclusive.
 *
 * Return the minimum number of operations required
 * to make the sum of values in nums1 equal to the sum of values in nums2.
 * Return -1 if it is not possible to make the sum of the two arrays equal.
 *
 * Input: nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * Output: 3
 * Explanation: You can make the sums of nums1 and nums2 equal with 3 operations. All indices are 0-indexed.
 * - Change nums2[0] to 6. nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2].
 * - Change nums1[5] to 1. nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2].
 * - Change nums1[2] to 2. nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2].
 *
 * Input: nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * Output: -1
 * Explanation: There is no way to decrease the sum of nums1 or to increase the sum of nums2 to make them equal.
 *
 * Input: nums1 = [6,6], nums2 = [1]
 * Output: 3
 * Explanation: You can make the sums of nums1 and nums2 equal with 3 operations. All indices are 0-indexed.
 * - Change nums1[0] to 2. nums1 = [2,6], nums2 = [1].
 * - Change nums1[1] to 2. nums1 = [2,2], nums2 = [1].
 * - Change nums2[0] to 4. nums1 = [2,2], nums2 = [4].
 */

// O(n + m) time | O(1) space
fun minOperations(nums1: IntArray, nums2: IntArray): Int {
    if (nums1.size * 6 < nums2.size || nums1.size > nums2.size * 6) return -1

    var sum1 = nums1.sum()
    val sum2 = nums2.sum()
    if (sum1 > sum2) return minOperations(nums2, nums1) // num1.sum() < num2.sum()

    val cnt = IntArray(6)
    nums1.forEach { cnt[6 - it]++ } // count of increases
    nums2.forEach { cnt[it - 1]++ } // count of decreases

    var i = 5
    var operations = 0
    while (sum2 > sum1) {
        while (cnt[i] == 0) i--
        sum1 += i
        cnt[i]--
        operations++
    }

    return operations
}
