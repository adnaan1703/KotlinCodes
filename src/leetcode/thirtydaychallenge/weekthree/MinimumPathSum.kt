package leetcode.thirtydaychallenge.weekthree

import kotlin.math.min

fun main() {
    var grid = arrayOf(
        intArrayOf(1, 3, 1),
        intArrayOf(1, 5, 1),
        intArrayOf(4, 2, 1)
    )
    println(minPathSum(grid))       // ans: 7

    grid = arrayOf(
        intArrayOf(1, 3, 1),
        intArrayOf(1, 1, 1),
        intArrayOf(4, 2, 1)
    )
    println(minPathSum(grid))       // ans: 5
}

fun minPathSum(grid: Array<IntArray>): Int {
    val memo: Array<IntArray> = Array(grid.size) { i -> IntArray(grid[i].size) }
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (i == 0 && j == 0) {
                memo[i][j] = grid[i][j]
                continue
            }

            memo[i][j] = min(memo.safeGet(i - 1, j), memo.safeGet(i, j - 1)) + grid[i][j]
        }
    }
    return memo[memo.lastIndex][memo[memo.lastIndex].lastIndex]
}

private fun Array<IntArray>.safeGet(i: Int, j: Int): Int {
    return this.getOrNull(i)?.getOrNull(j) ?: Int.MAX_VALUE
}