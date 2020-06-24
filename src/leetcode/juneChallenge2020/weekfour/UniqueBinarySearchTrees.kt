package leetcode.juneChallenge2020.weekfour

import utils.println

fun main() {
    numTrees(0).println()
    numTrees(2).println()
    numTrees(3).println()
    numTrees(4).println()
}

fun numTrees(n: Int): Int {
    val dp = IntArray(n + 1) { 0 }
    dp[0] = 1
    if (n >= 1) dp[1] = 1

    for (i in 2..n) {
        for (j in 1..i) {
            dp[i] = dp[i] + (dp[i - j] * dp[j - 1])
        }
    }
    return dp[n]
}