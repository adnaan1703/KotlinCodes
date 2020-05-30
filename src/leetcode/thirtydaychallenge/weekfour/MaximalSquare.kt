package leetcode.thirtydaychallenge.weekfour

import kotlin.math.max
import kotlin.math.min

fun main() {
    var matrix = arrayOf(
        charArrayOf('1', '0', '1', '0', '0'),
        charArrayOf('1', '0', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '0', '1', '0')
    )
    println(maximalSquare(matrix))      // ans: 4

    matrix = arrayOf(
        charArrayOf('0', '1', '1', '0', '1'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('0', '1', '1', '1', '0'),
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '1', '1', '1'),
        charArrayOf('0', '0', '0', '0', '0')
    )
    println(maximalSquare(matrix))      // ans: 9

    matrix = arrayOf(charArrayOf())
    println(maximalSquare(matrix))

    matrix = arrayOf()
    println(maximalSquare(matrix))

}

fun maximalSquare(matrix: Array<CharArray>): Int {
    var ans = 0

    if (matrix.isEmpty() || matrix[0].isEmpty())
        return 0

    val dp: Array<IntArray> = Array(matrix.size) { IntArray(matrix[0].size) }
    for (i in 0..matrix[0].lastIndex) {
        dp[0][i] = matrix[0][i].getBinaryValue()
        if (dp[0][i] == 1) ans = 1
    }

    for (i in 0..matrix.lastIndex) {
        dp[i][0] = matrix[i][0].getBinaryValue()
        if (dp[i][0] == 1) ans = 1
    }

    for (i in 1..matrix.lastIndex) {
        for (j in 1..matrix[i].lastIndex) {
            val num = matrix[i][j].getBinaryValue()
            if (num == 1) {
                dp[i][j] = min(dp[i - 1][j], min(dp[i][j - 1], dp[i - 1][j - 1])) + 1
                ans = max(ans, dp[i][j])
            } else {
                dp[i][j] = 0
            }
        }
    }

    return ans * ans
}

fun Char.getBinaryValue(): Int {
    return if (this == '1') 1 else 0
}
