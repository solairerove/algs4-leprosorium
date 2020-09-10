package com.github.solairerove.algs4.leprosorium.arrays;

import java.util.Arrays;

/**
 * Given two non-empty arrays of integers, write a function that determines
 * whether the second array is a subsequence of the first one.
 * <p>
 * Sample Input
 * array = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * sequence = [2, 3, 7, 8]
 */
public class ValidateSubsequence {
    public static void main(String... args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] sequence = {2, 3, 7, 8};

        System.out.printf("Arrays is %s\n", Arrays.toString(array));
        System.out.printf("Sequnce is %s\n", Arrays.toString(sequence));
        System.out.printf("Is subsequence %s\n", isSubsequence(array, sequence));
    }

    // O(N) time | O(1) space
    private static boolean isSubsequence(int[] array, int[] sequence) {
        int arrIdx = 0;
        int seqIdx = 0;

        while (arrIdx < array.length && seqIdx < sequence.length) {
            if (array[arrIdx] == sequence[seqIdx]) {
                seqIdx++;
            }
            arrIdx++;
        }

        return seqIdx == sequence.length;
    }
}
