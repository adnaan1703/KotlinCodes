package leetcode.juneChallenge2020.weekthree

import utils.println
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main() {
    val dungeon = arrayOf(
        intArrayOf(-2, -3, 3),
        intArrayOf(-5, -10, 1),
        intArrayOf(10, 30, -5)
    )
    calculateMinimumHP(dungeon).println()
}

fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
    val dp = Array(dungeon.size) { i -> IntArray(dungeon[i].size) }
    val row = dungeon.lastIndex
    val col = dungeon[row].lastIndex

    for (i in row downTo 0) {
        for (j in col downTo 0) {
            dp[i][j] = when {
                i == row && j == col -> abs(min(dungeon[i][j], 0)) + 1
                i == row -> max(dp[i][j + 1] - dungeon[i][j], 1)
                j == col -> max(dp[i + 1][j] - dungeon[i][j], 1)
                else -> max(min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j], 1)
            }
        }
    }
    return dp[0][0]
}

