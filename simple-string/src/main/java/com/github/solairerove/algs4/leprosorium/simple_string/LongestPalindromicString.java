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
        System.out.printf("For %s the longest palindrome is %s\n", s, getTheLongestPalindrome(s));
        System.out.printf("For %s the longest palindrome is %s", s, theLongestPalindrome(s));
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
        for (int i = 0; i < n / 2; i++)
            if (s.charAt(i) != s.charAt(n - 1 - i)) return false;
        return true;
    }

    // O(n^2) time | O(1) space
    private static String theLongestPalindrome(String s) {
        int[] theLongest = new int[]{0, 1};
        for (int i = 1; i < s.length(); i++) {
            var nonSym = findTheLargestPalindrome(s, i - 1, i + 1);
            var sym = findTheLargestPalindrome(s, i - 1, i);
            var current = nonSym[1] - nonSym[0]
                    > sym[1] - sym[0]
                    ? nonSym
                    : sym;
            theLongest = theLongest[1] - theLongest[0]
                    > current[1] - current[0]
                    ? theLongest
                    : current;
        }

        return s.substring(theLongest[0], theLongest[1]);
    }

    private static int[] findTheLargestPalindrome(String s, int low, int high) {
        while (low >= 0 && high < s.length()) {
            if (s.charAt(low) != s.charAt(high)) break;
            low--;
            high++;
        }

        return new int[]{low + 1, high};
    }
}
