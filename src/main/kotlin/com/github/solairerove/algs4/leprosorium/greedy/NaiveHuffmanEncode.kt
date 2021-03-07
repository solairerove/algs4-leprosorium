package com.github.solairerove.algs4.leprosorium.greedy

/**
 * abacabad
 * 4 14
 * a: 0
 * b: 10
 * c: 110
 * d: 111
 * 01001100100111
 */
fun main() {
    val s = "abacabad"

    val letterToFreq = getLetterToFrequency(s = s)
    val letterWeightStack = getLetterWeightStack(letterToFreq = letterToFreq)
    val huffmanResult = huffman(letterWeightStack = letterWeightStack)
    val dictionary = getDictionary(huffmanResult = huffmanResult)

    val encodedString = encodeString(stringToEncode = s, dictionary = dictionary)
    println("${dictionary.keys.size} ${encodedString.length}")
    dictionary.forEach { println("${it.key}: ${it.value}") }
    println(encodedString)
}

private fun getLetterToFrequency(s: String): Map<String, Int> {
    val letterToFreq = HashMap<String, Int>()
    for (l in s) {
        val letter = l.toString()
        if (letterToFreq.containsKey(letter)) {
            letterToFreq[letter] = letterToFreq[letter]!!.plus(1)
        } else {
            letterToFreq[letter] = 1
        }
    }

    return letterToFreq
}

private fun getLetterWeightStack(letterToFreq: Map<String, Int>): MutableList<LetterWeight> {
    return letterToFreq.map { LetterWeight(it.key, it.value) }.toMutableList()
}

private fun getMinLetterWeight(letterWeightStack: MutableList<LetterWeight>): LetterWeight {
    var min = 0;
    for (i in letterWeightStack.indices) {
        if (letterWeightStack[i].weight < letterWeightStack[min].weight) {
            min = i
        }
    }
    return letterWeightStack.removeAt(min)
}

private fun huffman(letterWeightStack: MutableList<LetterWeight>): List<List<String>> {
    val huffmanResult = mutableListOf<List<String>>()
    if (letterWeightStack.size == 1) {
        val letterWeight = getMinLetterWeight(letterWeightStack)
        huffmanResult.add(listOf(letterWeight.letter, "0"))
        return huffmanResult
    }
    while (letterWeightStack.size > 1) {
        val leftLetterWeight = getMinLetterWeight(letterWeightStack)
        val rightLetterWeight = getMinLetterWeight(letterWeightStack)

        val newLetter = leftLetterWeight.letter.plus(rightLetterWeight.letter)
        val newWeight = leftLetterWeight.weight.plus(rightLetterWeight.weight)

        val newLetterWeight = LetterWeight(letter = newLetter, weight = newWeight)
        letterWeightStack.add(newLetterWeight)

        huffmanResult.add(listOf(leftLetterWeight.letter, "0"))
        huffmanResult.add(listOf(rightLetterWeight.letter, "1"))
    }

    return huffmanResult
}

private fun getDictionary(huffmanResult: List<List<String>>): Map<String, String> {
    val dictionary = mutableMapOf<String, String>()

    for (innerList in huffmanResult) {
        val letters = innerList[0]
        val code = innerList[1]

        letters.forEach { dictionary.merge(it.toString(), code) { a, b -> b.plus(a) } }
    }

    return dictionary
}

private fun encodeString(stringToEncode: String, dictionary: Map<String, String>): String {
    val stringBuilder = StringBuilder()
    stringToEncode.forEach { stringBuilder.append(dictionary[it.toString()]) }

    return stringBuilder.toString()
}

data class LetterWeight(
    val letter: String,
    val weight: Int
)
