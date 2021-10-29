package com.github.solairerove.algs4.leprosorium.symbol_table

fun main() {
    val st = SequentialSearchST<String, Int>()
    st.put("A", 1)
    st.put("B", 2)
    st.put("C", 3)

    println(st.get("A")) // 1
    println(st.get("C")) // 3
}

private class SequentialSearchST<Key, Value> {
    private var first: Node? = null

    inner class Node(val key: Key, var value: Value?, val next: Node?)

    fun get(key: Key): Value? {
        var x = first
        while (x != null) {
            if (key?.equals(x.key) == true) {
                return x.value
            }
            x = x.next
        }

        return null
    }

    fun put(key: Key, value: Value?) {
        var x = first
        while (x != null) {
            if (key?.equals(x.key) == true) {
                x.value = value
                return
            }
            x = x.next
        }
        first = Node(key, value, first)
    }
}
