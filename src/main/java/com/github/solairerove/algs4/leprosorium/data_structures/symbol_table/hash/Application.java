package com.github.solairerove.algs4.leprosorium.data_structures.symbol_table.hash;

public class Application {
    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<>();
        st.put("X", 0);
        st.put("S", 1);
        st.put("R", 2);
        st.put("M", 3);
        st.put("H", 4);
        st.put("E", 5);
        st.put("C", 6);
        st.put("A", 11);

        System.out.println(st.get("X")); // 0
    }
}
