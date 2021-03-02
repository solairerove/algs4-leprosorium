package com.github.solairerove.algs4.leprosorium.recursion

fun main() {
    print("For 9 and 6 highest common factor is: '${gcd(9, 6)}'\n") // 3
    print("For 15 and 5 highest common factor is: '${gcd(15, 5)}'\n") // 5
    print("For 5 and 15 highest common factor is: '${gcd(5, 15)}'\n") // 5
    print("For 13 and 10 highest common factor is: '${gcd(13, 10)}'\n") // 1
    print("For 105 and 24 highest common factor is: '${gcd(105, 24)}'\n") // 3
    print("For 1111111 and 1234567 highest common factor is: '${gcd(1111111, 1234567)}'\n") // 1
    print("For 98 and 56 highest common factor is: '${iterativeGcd(98, 56)}'\n") // 14
    print("For 48 and 18 highest common factor is: '${iterativeGcd(48, 18)}'\n") // 6
    print("For 14159572 and 63967072 highest common factor is: '${iterativeGcd(14159572, 63967072)}'\n") // 4
}

// greatest common divisor
private fun gcd(p: Int, q: Int): Int {
    if (q == 0) {
        return p
    }

    val r = p % q
    return gcd(q, r)
}

// Euclid algo
private fun iterativeGcd(p: Int, q: Int): Int {
    var a = p
    var b = q
    while (b != 0) {
        val r = a % b
        a = b
        b = r
    }

    return a
}