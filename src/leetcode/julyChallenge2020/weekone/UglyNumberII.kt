package leetcode.julyChallenge2020.weekone

import utils.println
import kotlin.math.min

fun main() {
    nthUglyNumber(10).println()
    nthUglyNumber(1).println()
    nthUglyNumber(1690).println()
}

fun nthUglyNumber(n: Int): Int {
    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = 1

    var ptr2 = 1
    var ptr3 = 1
    var ptr5 = 1

    for (i in 2..n) {
        val jump2 = dp[ptr2] * 2
        val jump3 = dp[ptr3] * 3
        val jump5 = dp[ptr5] * 5

        dp[i] = minTrips(jump2, jump3, jump5)

        if (dp[i] == jump2) ptr2++
        if (dp[i] == jump3) ptr3++
        if (dp[i] == jump5) ptr5++
    }
    return dp[n]
}

private fun minTrips(a: Int, b: Int, c: Int): Int {
    return min(a, min(b, c))
}