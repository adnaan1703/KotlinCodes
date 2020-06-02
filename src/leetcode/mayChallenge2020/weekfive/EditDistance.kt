package leetcode.mayChallenge2020.weekfive

import utils.println
import kotlin.math.min

fun main() {
    minDistance("horse", "ros").println()
    minDistance("intention", "execution").println()
    minDistance("", "").println()
    minDistance("wow", "").println()
    minDistance("", "wow").println()
    minDistance("wow", "wow").println()
    minDistance("zoologicoarchaeologist", "zoogeologist").println()
}
    
    fun minDistance(word1: String, word2: String): Int {
        val dp = Array(word1.length + 1) { IntArray(word2.length + 1) }
        for (i in dp.indices) {
            for (j in dp[i].indices) {
                when {
                    i == 0 -> dp[i][j] = j
                    j == 0 -> dp[i][j] = i
                    word1[i - 1] == word2[j - 1] -> dp[i][j] = dp[i - 1][j - 1]
                    else -> {
                        dp[i][j] = 1 + minTrips(dp[i - 1][j], dp[i - 1][j - 1], dp[i][j - 1])
                    }
                }
            }
        }
        return dp[word1.length][word2.length]
    }

    fun minTrips(a: Int, b: Int, c: Int): Int {
        return min(a, min(b, c))
    }