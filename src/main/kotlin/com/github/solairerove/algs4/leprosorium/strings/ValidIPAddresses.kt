package com.github.solairerove.algs4.leprosorium.strings

import kotlin.math.min

fun main() {
    print(validIPAddresses("127001"))
    println()
    print(validIPAddresses("19216801"))
}

// O(1) time | O(1) space
private fun validIPAddresses(s: String): List<String> {
    val n = s.length
    val addresses = mutableListOf<String>()

    for (i in 1 until min(n, 4)) {
        val parts = mutableListOf("", "", "", "")

        parts[0] = s.substring(0, i)
        if (!isValidPart(parts[0])) continue

        for (j in i + 1 until i + min(n - i, 4)) {
            parts[1] = s.substring(i, j)
            if (!isValidPart(parts[1])) continue

            for (k in j + 1 until j + min(n - j, 4)) {
                parts[2] = s.substring(j, k)
                parts[3] = s.substring(k)

                if (isValidPart(parts[2]) && isValidPart(parts[3])) {
                    addresses.add(parts.joinToString("."))
                }
            }
        }
    }

    return addresses
}

private fun isValidPart(s: String): Boolean {
    val asInt = s.toInt()
    if (asInt > 255) return false

    return s.length == asInt.toString().length
}
