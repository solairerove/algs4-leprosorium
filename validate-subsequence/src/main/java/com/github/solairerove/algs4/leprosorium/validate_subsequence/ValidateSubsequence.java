package com.github.solairerove.algs4.leprosorium.validate_subsequence;

import java.util.List;

/**
 * Given two non-empty arrays of integers, write a function that determines
 * whether the second array is a subsequence of the first one.
 * <p>
 * A subsequence of array is a set of numbers that aren't necessarily
 * adjacent in the array but that are in the same order as they appear
 * in the array.
 * <p>
 * Sample Input
 * array = [5, 1, 22, 25, 6, -1, 8, 10]
 * sequence = [1, 6, -1, 10]
 */
public class ValidateSubsequence {
    public static void main(String... args) {
        List<Integer> array = List.of(5, 1, 22, 25, 6, -1, 8, 10);
        List<Integer> sequence = List.of(1, 6, -1, 10);

        System.out.printf("Arrays is %s\n", array);
        System.out.printf("Sequnce is %s\n", sequence);
        System.out.printf("Is subsequence %s\n", isValidSubsequence(array, sequence));
    }

    // O(N) time | O(1) space
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int arrIdx = 0;
        int seqIdx = 0;

        while (arrIdx < array.size() && seqIdx < sequence.size()) {
            if (array.get(arrIdx).equals(sequence.get(seqIdx))) {
                seqIdx++;
            }
            arrIdx++;
        }

        return seqIdx == sequence.size();
    }
}
