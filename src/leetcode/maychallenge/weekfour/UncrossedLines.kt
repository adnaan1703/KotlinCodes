package leetcode.maychallenge.weekfour

import utils.println
import kotlin.math.max

fun main() {
    maxUncrossedLines(intArrayOf(1, 4, 2), intArrayOf(1, 2, 4)).println()
    maxUncrossedLines(intArrayOf(2, 5, 1, 2, 5), intArrayOf(10, 5, 2, 1, 5, 2)).println()
    maxUncrossedLines(intArrayOf(1, 3, 7, 1, 7, 5), intArrayOf(1, 9, 2, 5, 1)).println()
}

fun maxUncrossedLines(A: IntArray, B: IntArray): Int {
    val dp = Array(A.size) { IntArray(B.size) }
    A.forEachIndexed { i, it1 ->
        B.forEachIndexed { j, it2 ->
            if (it1 == it2) {
                dp[i][j] = dp.safeGet(i - 1, j - 1) + 1
            } else {
                dp[i][j] = max(dp.safeGet(i, j - 1), dp.safeGet(i - 1, j))
            }
        }
    }
    return dp[A.lastIndex][B.lastIndex]
}

private fun Array<IntArray>.safeGet(i: Int, j: Int): Int {
    return this.getOrNull(i)?.getOrNull(j) ?: 0
}