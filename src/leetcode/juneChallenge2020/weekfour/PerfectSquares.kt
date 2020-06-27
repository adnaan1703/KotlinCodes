package leetcode.juneChallenge2020.weekfour

import utils.println
import kotlin.math.min

fun main() {
    numSquares(12).println()
    numSquares(13).println()
}

fun numSquares(n: Int): Int {
    val dp = IntArray(n + 1) { Int.MAX_VALUE }
    dp[0] = 0
    dp[1] = 1
    for (i in 1..n) {
        var j = 1
        while (j * j <= i) {
            dp[i] = min(dp[i], dp.safeIncrement(i - (j * j)))
            j++
        }
    }
    return dp[n];
}

fun IntArray.safeIncrement(index: Int): Int {
    return this.getOrNull(index)?.plus(1) ?: Int.MAX_VALUE
}