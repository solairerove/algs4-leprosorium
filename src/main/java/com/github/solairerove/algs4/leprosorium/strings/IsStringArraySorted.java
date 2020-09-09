package com.github.solairerove.algs4.leprosorium.strings;

import java.util.Arrays;

public class IsStringArraySorted {
    public static void main(String[] args) {
        String[] strings1 = {"a", "b", "c"};
        System.out.printf("%s is sorted: %s\n", Arrays.toString(strings1), isSorted(strings1));

        String[] strings2 = {"hui", "pizda", "apple"};
        System.out.printf("%s is sorted: %s\n", Arrays.toString(strings2), isSorted(strings2));

        String[] strings3 = {"kandehai", "veselei"};
        System.out.printf("%s is sorted: %s\n", Arrays.toString(strings3), isSorted(strings3));
    }

    public static boolean isSorted(String[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (a[i].compareTo(a[i - 1]) < 0) {
                return false;
            }
        }

        return true;
    }
}
