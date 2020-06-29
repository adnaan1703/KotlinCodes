package leetcode.juneChallenge2020.weekfive

import utils.println

fun main() {
    uniquePaths(3, 2).println()
    uniquePaths(7, 3).println()
    uniquePaths(1, 3).println()
}

fun uniquePaths(m: Int, n: Int): Int {
    val dp = Array(m) { IntArray(n) { 1 } }

    for (i in 1 until m) {
        for (j in 1 until n) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }
    return dp.last().last()
}