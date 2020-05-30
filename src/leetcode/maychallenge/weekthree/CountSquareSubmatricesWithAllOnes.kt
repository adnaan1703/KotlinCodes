package leetcode.maychallenge.weekthree

import utils.println
import kotlin.math.min

fun main() {
    val matrix = arrayOf(
        intArrayOf(0, 1, 1, 1),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(0, 1, 1, 1)
    )
    countSquares(matrix).println()
}

fun countSquares(matrix: Array<IntArray>): Int {
    var ans = 0

    for (i in matrix.indices) {
        matrix[i].forEachIndexed { j, it ->
            if (it != 0) {
                matrix[i][j] = minTrips(
                    matrix.safeGet(i - 1, j),
                    matrix.safeGet(i - 1, j - 1),
                    matrix.safeGet(i, j - 1)
                ) + 1
                ans += matrix[i][j]
            }
        }
    }
    return ans
}

fun minTrips(a: Int, b: Int, c: Int): Int {
    return min(a, min(b, c))
}

private fun Array<IntArray>.safeGet(i: Int, j: Int): Int {
    if (i >= 0 && i <= this.lastIndex && j >= 0 && j <= this[i].lastIndex)
        return this[i][j]
    return 0
}