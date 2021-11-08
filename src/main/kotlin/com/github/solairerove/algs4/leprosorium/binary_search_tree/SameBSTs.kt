package com.github.solairerove.algs4.leprosorium.binary_search_tree

fun main() {
    println(sameBsts(listOf(1, 2, 3), listOf(1, 2, 3))) // true
    println(sameBsts(listOf(1, 2, 3), listOf(1, 3, 2))) // false
}

// O(nˆ2) time | O(d) space
// n is number of nodes
// d is depth
fun sameBsts(
        arrOne: List<Int>,
        arrTwo: List<Int>,
        idxOne: Int = 0,
        idxTwo: Int = 0,
        min: Int = Int.MIN_VALUE,
        max: Int = Int.MAX_VALUE
): Boolean {
    if (idxOne == -1 || idxTwo == -1) return idxOne == idxTwo
    if (arrOne[idxOne] != arrTwo[idxTwo]) return false

    val smallOne = getSmall(arrOne, idxOne, min)
    val smallTwo = getSmall(arrTwo, idxTwo, min)
    val bigOne = getBig(arrOne, idxOne, max)
    val bigTwo = getBig(arrTwo, idxTwo, max)

    val curr = arrOne[idxOne]
    val left = sameBsts(arrOne, arrTwo, smallOne, smallTwo, min, curr)
    val right = sameBsts(arrOne, arrTwo, bigOne, bigTwo, curr, max)

    return left && right
}

fun getSmall(arr: List<Int>, idx: Int, min: Int): Int {
    for (i in idx + 1 until arr.size) {
        if (arr[i] < arr[idx] && arr[i] >= min) {
            return i
        }
    }
    return -1
}

fun getBig(arr: List<Int>, idx: Int, max: Int): Int {
    for (i in idx + 1 until arr.size) {
        if (arr[i] >= arr[idx] && arr[i] < max) {
            return i
        }
    }
    return -1
}
