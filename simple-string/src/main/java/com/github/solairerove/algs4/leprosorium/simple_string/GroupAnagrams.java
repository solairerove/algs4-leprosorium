package com.github.solairerove.algs4.leprosorium.simple_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * input [tic, cit, cti, word, rowd]
 * output [[tic, cit, cti], [word, rowd]]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        var input = new String[]{"cinema", "tic", "cit", "cti", "word", "rowd", "iceman"};
        System.out.println(Arrays.toString(input));
        List<List<String>> groupedAnagrams = getGroupedAnagrams(input);
        System.out.print("[");
        int cnt = 0;
        for (List<String> el : groupedAnagrams) {
            cnt++;
            if (cnt == groupedAnagrams.size()) {
                System.out.printf("%s", el);
            } else {
                System.out.printf("%s, ", el);
            }
        }
        System.out.print("]");
    }

    private static List<List<String>> getGroupedAnagrams(String[] words) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            var currentWord = new String(chars);

            if (map.containsKey(currentWord)) {
                map.get(currentWord).add(word);
            } else {
                map.put(currentWord, new ArrayList<>(Collections.singletonList(word)));
            }
        }

        return new ArrayList<>(map.values());
    }
}
