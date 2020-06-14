package leetcode.juneChallenge2020.weektwo

import utils.println
import kotlin.math.min

fun main() {
    val flights = arrayOf(
        intArrayOf(0, 1, 100),
        intArrayOf(1, 2, 100),
        intArrayOf(0, 2, 500)
    )
    findCheapestPrice(3, flights, 0, 2, 1).println()
    findCheapestPrice(3, flights, 0, 2, 0).println()
}

fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, K: Int): Int {
    val dp = Array(K + 2) { LongArray(n) { Int.MAX_VALUE.toLong() } }
    dp[0][src] = 0

    for (i in 1 until K + 2) {
        dp[i][src] = 0
        flights.forEach {
            dp[i][it[1]] = min(dp[i][it[1]], dp[i - 1][it[0]] + it[2])
        }
    }
    val ans = dp[K + 1][dst].toInt()
    return if (ans == Int.MAX_VALUE) -1 else ans
}