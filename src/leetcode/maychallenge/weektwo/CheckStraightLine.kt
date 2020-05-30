package leetcode.maychallenge.weektwo

import utils.println

fun main() {
    var coordinates = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(2, 2),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(5, 6),
        intArrayOf(7, 7)
    )
    checkStraightLine(coordinates).println()        // ans: false

    coordinates = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(5, 6),
        intArrayOf(6, 7)
    )
    checkStraightLine(coordinates).println()        // ans: true

    coordinates = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(1, 2),
        intArrayOf(1, 4),
        intArrayOf(1, 5),
        intArrayOf(1, 6),
        intArrayOf(1, 17)
    )
    checkStraightLine(coordinates).println()        // ans: true

    coordinates = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 2),
        intArrayOf(3, 2),
        intArrayOf(4, 2),
        intArrayOf(5, 2),
        intArrayOf(612, 2)
    )
    checkStraightLine(coordinates).println()        // ans: true

    coordinates = arrayOf(
        intArrayOf(-1, 2),
        intArrayOf(-2, 3),
        intArrayOf(-3, 4),
        intArrayOf(-4, 5),
        intArrayOf(-5, 6),
        intArrayOf(-6, 7)
    )
    checkStraightLine(coordinates).println()        // ans: true


}

fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
    val slope: Float = findSlope(coordinates[0], coordinates[1])
    for (index in 2..coordinates.lastIndex) {
        val checkSlope = findSlope(coordinates[0], coordinates[index])
        if (checkSlope != slope)
            return false
    }
    return true
}

fun findSlope(point1: IntArray, point2: IntArray): Float {
    return (point2[1] - point1[1]).toFloat() / (point2[0] - point1[0]).toFloat()
    // for denominator equals zero kotlin will return Float.POSITIVE_INFINITY
}