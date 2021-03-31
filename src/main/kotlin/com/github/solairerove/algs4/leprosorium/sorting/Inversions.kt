package com.github.solairerove.algs4.leprosorium.sorting

fun main() {
    val items = mutableListOf(2, 3, 9, 2, 9) // 2
    print("items: $items \n")
    print("inversions: ${count(items)} \n")
}

private fun count(arr: MutableList<Int>): Long {
    val n = arr.size
    val b = MutableList(n) { i -> i }
    val aux = MutableList(n) { i -> i }

    for (i in 0 until n) {
        b[i] = arr[i]
    }

    return count(arr, b, aux, 0, n - 1)
}

private fun count(arr: MutableList<Int>, b: MutableList<Int>, aux: MutableList<Int>, low: Int, high: Int): Long {
    var inversions = 0L

    if (high <= low) {
        return 0
    }

    val mid = low + (high - low) / 2

    inversions += count(arr, b, aux, low, mid)
    inversions += count(arr, b, aux, mid + 1, high)
    inversions += merge(b, aux, low, mid, high)

    return inversions
}

private fun merge(arr: MutableList<Int>, aux: MutableList<Int>, low: Int, mid: Int, high: Int): Long {
    var inversions = 0L

    for (k in low..high) {
        aux[k] = arr[k]
    }

    var i = low
    var j = mid + 1

    for (k in low..high) {
        when {
            i > mid -> arr[k] = aux[j++]
            j > high -> arr[k] = aux[i++]
            aux[j] < aux[i] -> {
                arr[k] = aux[j++]
                inversions += (mid - i + 1)
            }
            else -> arr[k] = aux[i++]
        }
    }

    return inversions
}
