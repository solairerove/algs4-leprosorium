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
        int[] threeLargest = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : array) {
            updateLargest(threeLargest, num);
        }

        return threeLargest;
    }

    private static void updateLargest(int[] threeLargest, int num) {
        if (num > threeLargest[2]) {
            moveAndUpdate(threeLargest, num, 2);
        } else if (num > threeLargest[1]) {
            moveAndUpdate(threeLargest, num, 1);
        } else if (num > threeLargest[0]) {
            moveAndUpdate(threeLargest, num, 0);
        }
    }

    private static void moveAndUpdate(int[] array, int num, int idx) {
        for (int i = 0; i <= idx; ++i) {
            if (i == idx) {
                array[i] = num;
            } else {
                array[i] = array[i + 1];
            }
        }
    }
}
