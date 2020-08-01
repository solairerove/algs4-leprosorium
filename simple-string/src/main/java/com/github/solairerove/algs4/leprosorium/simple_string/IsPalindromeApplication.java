package com.github.solairerove.algs4.leprosorium.simple_string;

public class IsPalindromeApplication {
    public static void main(String[] args) {
        System.out.printf("'string' is palindrome %s\n", isPalindrome("string"));
        System.out.printf("'aba' is palindrome %s\n", isPalindrome("aba"));
        System.out.printf("'sobaka' is palindrome %s\n", isPalindrome("sobaka"));
        System.out.printf("'civic' is palindrome %s\n", isPalindrome("civic"));
        System.out.printf("'level' is palindrome %s\n", isPalindrome("level"));
        System.out.printf("'racecar' is palindrome %s\n", isPalindrome("racecar"));
    }

    private static boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; ++i) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
