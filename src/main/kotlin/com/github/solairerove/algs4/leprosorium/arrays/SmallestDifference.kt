package com.github.solairerove.algs4.leprosorium.arrays

fun main() {
    val arrOne = mutableListOf(2, -9, 0, 14, 1, -8, -3, -1, 8, -6, 5, -5)
    val arrTwo = mutableListOf(15, -8, 3, 1, 7, -10, 2, -1, 4, -3, 17, -2)

    print(smallestDifference(arrOne, arrTwo)) // [-8, -8]
}

// O(nlog(n) + mlog(m)) time | O(1) space
private fun smallestDifference(arrOne: MutableList<Int>, arrTwo: MutableList<Int>): List<Int> {
    arrOne.sort()
    arrTwo.sort()

    var smallestPair = listOf<Int>()
    var idxOne = 0
    var idxTwo = 0
    var smallest = Int.MAX_VALUE
    var curr: Int

    while (idxOne < arrOne.size && idxTwo < arrTwo.size) {
        val numOne = arrOne[idxOne]
        val numTwo = arrTwo[idxTwo]

        when {
            numOne < numTwo -> {
                curr = numTwo - numOne
                idxOne++
            }

            numTwo < numOne -> {
                curr = numOne - numTwo
                idxTwo++
            }

            else -> return listOf(numOne, numTwo)
        }

        if (curr < smallest) {
            smallest = curr
            smallestPair = listOf(numOne, numTwo)
        }
    }

    return smallestPair
}
