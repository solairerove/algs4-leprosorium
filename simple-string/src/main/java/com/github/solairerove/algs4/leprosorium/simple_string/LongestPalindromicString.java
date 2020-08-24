package com.github.solairerove.algs4.leprosorium.simple_string;

/**
 * given string, return longest palindrome substring.
 * <p>
 * s = "zyabcdeyyzzyy"
 * result = yyzzyy
 */
public class LongestPalindromicString {
    public static void main(String[] args) {
        var s = "zyabcdeyyzzyy";
        System.out.printf("For %s the longest palindrome is %s", s, getTheLongestPalindrome(s));
    }

    // O(n^3) time | O(1) space
    private static String getTheLongestPalindrome(String s) {
        int n = s.length();
        if (n == 1) return s;

        var theLongest = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                var sub = s.substring(i, j + 1);
                if (sub.length() > theLongest.length() && isPalindrome(sub)) theLongest = sub;
            }
        }

        return theLongest;
    }

    private static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++)
            if (s.charAt(i) != s.charAt(n - 1 - i)) return false;
        return true;
    }
}
