package com.github.solairerove.algs4.leprosorium.arrays;

/**
 * Find length of longest peak(adjacent increasing elements) in array.
 */
public class LongestPeak {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 4, -1, 12, 10, 6, 5, 4, 3, 2, -1, -3, 2, 4}; // 10
        System.out.println(longestPeak(a));
    }

    private static int longestPeak(int[] a) {
        int n = a.length;
        int longestPeak = 0, i = 1;

        while (i < n - 1) {
            var isPeak = a[i] > a[i - 1] && a[i] > a[i + 1];
            if (!isPeak) {
                i++;
                continue;
            }

            int leftIdx = i - 2, rightIdx = i + 2;
            while (leftIdx >= 0 && a[leftIdx] < a[leftIdx + 1]) leftIdx--;
            while (rightIdx < n && a[rightIdx] < a[rightIdx - 1]) rightIdx++;

            longestPeak = Math.max(longestPeak, rightIdx - leftIdx - 1);
            i = rightIdx;
        }

        return longestPeak;
    }
}
