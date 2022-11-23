package com.github.solairerove.algs4.leprosorium.arrays

/**
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
 * find two numbers such that they add up to a specific target number.
 *
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
 *
 * Return the indices of the two numbers, index1 and index2,
 * added by one as an integer array [index1, index2] of length 2.
 *
 * The tests are generated such that there is exactly one solution.
 * You may not use the same element twice.
 *
 * Your solution must use only constant extra space.
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
 */

// O(n) time | O(1) space
fun twoSumSorted(numbers: IntArray, target: Int): IntArray {
    var low = 0
    var high = numbers.size - 1

    while (low < high) {
        val potentialSum = numbers[low] + numbers[high]

        when {
            potentialSum < target -> low++
            potentialSum > target -> high--
            else -> return intArrayOf(low + 1, high + 1)
        }
    }

    return intArrayOf()
}
