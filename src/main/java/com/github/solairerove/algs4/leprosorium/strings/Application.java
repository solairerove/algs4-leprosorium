package com.github.solairerove.algs4.leprosorium.strings;

import java.util.HashMap;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        saveWord("abca");
        saveWord("abcc");
        System.out.println(getWord('c'));
    }

    private static final Map<String, Map<Character, Integer>> words = new HashMap<>();


    // word with max letter entry
    // проект про заказ дебетовых карт
    public static void saveWord(String word) {
        Map<Character, Integer> entryCounts = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character curr = word.charAt(i);
            if (entryCounts.containsKey(curr)) {
                entryCounts.put(curr, entryCounts.get(curr) + 1);
            } else {
                entryCounts.put(curr, 0);
            }
        }
        words.put(word, entryCounts);
    }

    // max in word
    public static String getWord(char c) {
        int max = 0;
        String toReturn = "";
        for (Map.Entry<String, Map<Character, Integer>> e : words.entrySet()) {
            Map<Character, Integer> entryCount = e.getValue();
            if (max < entryCount.get(c)) {
                max = entryCount.get(c);
                toReturn = e.getKey();
            }
        }

        return toReturn;
    }
}
