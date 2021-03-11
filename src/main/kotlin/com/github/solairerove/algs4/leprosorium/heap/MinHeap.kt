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

    private val heap = buildHeap(arr)

    private fun buildHeap(arr: MutableList<Int>): MutableList<Int> {
        val parentIdx = (arr.size - 2) / 2
        for (k in parentIdx downTo 0) {
            siftDown(arr, k, arr.size - 1)
        }

        return arr
    }

    private fun siftDown(arr: MutableList<Int>, k: Int, n: Int) {
        var idx = k
        var childOne = idx * 2 + 1
        while (childOne <= n) {
            val childTwo = if (idx * 2 + 2 <= n) idx * 2 + 2 else -1
            val idxToSwap: Int = if (childTwo != -1 && arr[childTwo] < arr[childOne]) childTwo else childOne

            if (arr[idxToSwap] < arr[idx]) {
                swap(arr, idxToSwap, idx)
                idx = idxToSwap
                childOne = idx * 2 + 1
            } else {
                return
            }
        }
    }

    private fun siftUp(arr: MutableList<Int>, k: Int) {
        var idx = k
        var parentIdx = (k - 1) / 2

        while (idx > 0 && heap[idx] < heap[parentIdx]) {
            swap(arr, idx, parentIdx)
            idx = parentIdx
            parentIdx = (idx - 1) / 2
        }
    }

    fun peek(): Int {
        return heap[0]
    }

    fun remove(): Int {
        swap(heap, 0, heap.size - 1)
        val min = heap.removeAt(heap.size - 1)
        siftDown(heap, 0, heap.size - 1)

        return min
    }

    fun insert(value: Int) {
        heap.add(value)
        siftUp(heap, heap.size - 1)
    }

    fun swap(arr: MutableList<Int>, i: Int, j: Int) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }
}
