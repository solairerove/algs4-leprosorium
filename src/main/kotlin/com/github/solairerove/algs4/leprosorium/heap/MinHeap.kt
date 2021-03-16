package com.github.solairerove.algs4.leprosorium.heap

fun main() {
    val heap = MinHeap(mutableListOf(6, 5, 7, 1, 8, 10))
    heap.insert(11)
    heap.insert(3)
    heap.insert(4)
    heap.insert(20)
    println(heap.remove())
    println(heap.remove())
    println(heap.remove())
}

class MinHeap(arr: MutableList<Int>) {

    private var heap: MutableList<Int> = arr

    init {
        val n = arr.size
        for (k in n / 2 downTo 0) {
            sink(arr, k, n - 1)
        }
    }

    // O(1) time | O(1) space
    fun peek(): Int {
        return heap[0]
    }

    // O(log(n)) time | O(1) space
    fun remove(): Int {
        swap(heap, 0, heap.size - 1)
        val min = heap.removeAt(heap.size - 1)
        sink(heap, 0, heap.size - 1)

        return min
    }

    // O(log(n)) time | O(1) space
    fun insert(value: Int) {
        heap.add(value)
        swim(heap, heap.size - 1)
    }

    // O(log(n)) time | O(1) space
    private fun sink(arr: MutableList<Int>, k: Int, n: Int) {
        var idx = k
        while (idx * 2 + 1 <= n) {
            var j = idx * 2 + 1
            if (j < n && less(arr, j, j + 1)) j++
            if (!less(arr, idx, j)) break
            swap(arr, idx, j)
            idx = j
        }
    }

    // O(log(n)) time | O(1) space
    private fun swim(arr: MutableList<Int>, k: Int) {
        var idx = k
        while (idx > 0 && less(arr, (idx - 1) / 2, idx)) {
            swap(arr, (idx - 1) / 2, idx)
            idx = (idx - 1) / 2
        }
    }

    private fun less(arr: MutableList<Int>, i: Int, j: Int): Boolean {
        return arr[i] > arr[j]
    }

    private fun swap(arr: MutableList<Int>, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}
