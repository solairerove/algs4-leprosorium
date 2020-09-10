package com.github.solairerove.algs4.leprosorium.strings;

import java.util.HashMap;
import java.util.Map;

/*
Given a string with repeated characters, rearrange the
 string so that no two adjacent characters are the same.
 If this is not possible, return None.
 For example, given "aaabbc", you could return "ababac".
 Given "aaab", return None.
 */
public class RearrangeRepeatedCharactersInString {
    public static void main(String[] args) {
        String s1 = "aaabbc";
        String s2 = "aaab"; // None
        String s3 = "aaabbbbb"; // None
        String s4 = "caaabbbbbb"; // None
        String s5 = "aaaaabbc"; // None

        System.out.println(isNone(getMap(s1), s1.length()));
        System.out.println(isNone(getMap(s2), s2.length()));
        System.out.println(isNone(getMap(s3), s3.length()));
        System.out.println(isNone(getMap(s4), s4.length()));
        System.out.println(isNone(getMap(s5), s5.length()));
    }

    private static boolean isNone(Map<Character, Integer> map, int length) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            var current = entry.getValue();
            if (current > length - current) {
                return false;
            }
        }

        return true;
    }

    private static Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }

        return map;
    }
}
