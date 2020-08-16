package com.github.solairerove.algs4.leprosorium.simple_arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * take array that contains integers and some other special arrays
 * and calculate its product sum by summed els in arrays and multiply to its depth.
 * [] is 1 depth
 * [[]] is 2 depth
 * [z + y] = z + y
 * [z + [x + y]] = z + 2 * (x + y)
 */
public class ProductSum {
    // [2, 5, [6, -2], 4, [7, [-10, 5], 4]]
    public static void main(String... args) {
        List<Object> array = new ArrayList<>();
        array.add(2);
        array.add(5);

        List<Integer> inner = new ArrayList<>();
        inner.add(6);
        inner.add(-2);

        array.add(inner);

        array.add(4);

        List<Integer> inner3 = new ArrayList<>();
        inner3.add(-10);
        inner3.add(5);

        List<Object> inner2 = new ArrayList<>();
        inner2.add(7);
        inner2.add(inner3);
        inner2.add(4);

        array.add(inner2);
    }
}
