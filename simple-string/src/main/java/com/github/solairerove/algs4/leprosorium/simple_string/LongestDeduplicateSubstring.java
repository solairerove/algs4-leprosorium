package com.github.solairerove.algs4.leprosorium.simple_string;

import java.util.HashMap;
import java.util.Map;

public class LongestDeduplicateSubstring {
    public static void main(String[] args) {
        String s = "nikitaloxpizdec"; // taloxpizdec
        System.out.printf("%s %s", s, getTheLongestDeduplicateSubstring(s));
    }

    // O(n) time | O(min(n, a)) space, where a is unique set of chars
    private static String getTheLongestDeduplicateSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int[] longest = {0, 1};
        int startIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentLetter = s.charAt(i);

            if (map.containsKey(currentLetter)) {
                startIdx = Math.max(startIdx, map.get(currentLetter) + 1);
            }

            if (longest[1] - longest[0] < i + 1 - startIdx) {
                longest = new int[]{startIdx, i + 1};
            }

            map.put(currentLetter, i);
        }

        return s.substring(longest[0], longest[1]);
    }
}
