package leetcode.juneChallenge2020.weekone

import utils.println

fun main() {
    change(5, intArrayOf(1, 2, 5)).println()
}

fun change(amount: Int, coins: IntArray): Int {
    val dp = IntArray(amount + 1)
    dp[0] = 1

    coins.forEach { coin ->
        for (i in 1..amount) {
            dp[i] += dp.getOrElse(i - coin) { 0 }
        }
    }
    return dp[amount]
}