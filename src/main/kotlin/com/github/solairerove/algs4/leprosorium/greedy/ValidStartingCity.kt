package com.github.solairerove.algs4.leprosorium.greedy

/**
 * array of distances
 * each city has fuel
 * car can drive miles per gallon
 */
fun main() {
    val distances = mutableListOf(10, 15, 10, 25, 5)
    val fuel = mutableListOf(1, 2, 3, 1, 2)
    val mpg = 5

    print(validStartingCity(distances, fuel, mpg))
}

// O(n) time | O(1) space
private fun validStartingCity(distances: List<Int>, fuel: List<Int>, mpg: Int): Int {
    var currMiles = 0
    var idx = 0
    var totalMiles = 0

    for (i in 1 until distances.size) {
        val prevDistance = distances[i - 1]
        val prevFuel = fuel[i - 1]
        currMiles += prevFuel * mpg - prevDistance

        if (currMiles < totalMiles) {
            idx = i
            totalMiles = currMiles
        }
    }

    return idx
}
