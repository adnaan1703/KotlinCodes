package leetcode.aprilChallenge2020.weekfour

import kotlin.math.max

fun main() {
    println(longestCommonSubsequence("abc", "abc"))
    println(longestCommonSubsequence("abcde", "ace"))
    println(longestCommonSubsequence("abc", "def"))
}

fun longestCommonSubsequence(text1: String, text2: String): Int {
    val dp: Array<IntArray> = Array(text1.length + 1) { IntArray(text2.length + 1) }

    for (i in 1..dp.lastIndex) {
        for (j in 1..dp[i].lastIndex) {
            if (text1[i - 1] == text2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + 1
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp.last().last()
}