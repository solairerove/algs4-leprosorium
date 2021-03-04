package com.github.solairerove.algs4.leprosorium.greedy

import java.text.DecimalFormat

fun main() {
    var backPackSize = 50

    val items = mutableListOf(
        Item(worth = 60, volume = 20, worthPerVolume = (60 / 20).toDouble()),
        Item(worth = 100, volume = 50, worthPerVolume = (100 / 50).toDouble()),
        Item(worth = 120, volume = 30, worthPerVolume = (120 / 30).toDouble())
    )

    items.sortByDescending { it.worthPerVolume }

    var res = 0.0
    for (item in items) {
        if (item.volume < backPackSize) {
            res += item.worth
            backPackSize -= item.volume
        } else {
            res += (backPackSize / item.volume).toDouble() * item.worth.toDouble()
            break
        }
    }

    val df = DecimalFormat("#####0.000")
    print(df.format(res))
}

data class Item(
    val worth: Int,
    val volume: Int,
    val worthPerVolume: Double
)
