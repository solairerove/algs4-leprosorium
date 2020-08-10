package com.github.solairerove.algs4.leprosorium.three_largest_number;

import java.util.Arrays;

/**
 * Write a function that takes in an array of at least three integers and,
 * without sorting returns a sorted array of three largest integers in the input array.
 * <p>
 * The function should return duplicate integers if necessary;
 * for example it should return [11, 11, 13] for an input array of [11, 6, 10, 11, 13, 4]
 * <p>
 * Sample input
 * array = [142, 2, 18, -8, -18, -28, 19, 641, 9, 18, 18]
 * <p>
 * Sample output
 * [19, 142, 641]
 */
public class ThreeLargestNumber {

    public static void main(String... args) {
        int[] array = new int[]{142, 2, 18, -8, -18, -28, 19, 641, 9, 18, 18};
        System.out.printf("%s\n", Arrays.toString(array));
        System.out.printf("%s\n", Arrays.toString(getThreeLargestNumbers(array)));
    }

    // O(N) time | O(1) space
    private static int[] getThreeLargestNumbers(int[] array) {
        int[] threeLargestNumbers = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : array) {
            if (num > threeLargestNumbers[2]) {
                shiftAndUpdate(threeLargestNumbers, num, 2);
            } else if (num > threeLargestNumbers[1]) {
                shiftAndUpdate(threeLargestNumbers, num, 1);
            } else if (num > threeLargestNumbers[0]) {
                shiftAndUpdate(threeLargestNumbers, num, 0);
            }
        }

        return threeLargestNumbers;
    }

    /*
    [1, 2, 3] <- 4
	[2, 2, 3] <- 4
	[2, 3, 3] <- 4
	[2, 3, 4]
     */
    private static void shiftAndUpdate(int[] array, int num, int idx) {
        for (int i = 0; i <= idx; ++i) {
            if (i == idx) {
                array[i] = num;
            } else {
                array[i] = array[i + 1];
            }
        }
    }
}
