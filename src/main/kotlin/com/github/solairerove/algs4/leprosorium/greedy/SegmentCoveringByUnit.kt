package com.github.solairerove.algs4.leprosorium.greedy

import java.util.*
import kotlin.Comparator

fun main() {
    val segments = listOf(
        listOf(4, 7),
        listOf(1, 3),
        listOf(2, 5),
        listOf(5, 6),
    )

    val points = mutableListOf<Point>()
    for (i in segments.indices) {
        val segment = segments[i]
        val leftPoint = Point(value = segment[0], segmentNum = i + 1, pointType = PointType.LEFT)
        val rightPoint = Point(value = segment[1], segmentNum = i + 1, pointType = PointType.RIGHT)
        points.add(leftPoint)
        points.add(rightPoint)
    }

    Collections.sort(points, Point.pointComparator)

    val segmentNums = mutableSetOf<Int>()
    val res = mutableListOf<Int>()
    for (currPoint in points) {
        val segmentNum = currPoint.segmentNum

        if (PointType.LEFT == currPoint.pointType) {
            segmentNums.add(segmentNum)
        } else {
            if (segmentNums.contains(segmentNum)) {
                segmentNums.clear()
                res.add(currPoint.value)
            }
        }
    }

    println(res.size)
    res.forEach { print("$it ") }
}

data class Point(
    val value: Int,
    val segmentNum: Int,
    val pointType: PointType
) {

    companion object {
        val pointComparator = Comparator<Point> { p1, p2 ->
            val valCompare = p1.value.compareTo(p2.value)

            if (valCompare == 0) {
                if (PointType.LEFT == p1.pointType) -1 else 1
            } else {
                valCompare
            }
        }
    }
}

enum class PointType {
    LEFT, RIGHT
}
