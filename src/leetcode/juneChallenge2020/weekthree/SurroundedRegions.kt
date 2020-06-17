package leetcode.juneChallenge2020.weekthree

import utils.print

fun main() {
    val board = arrayOf(
        charArrayOf('X', 'X', 'X', 'X'),
        charArrayOf('X', 'O', 'O', 'X'),
        charArrayOf('X', 'X', 'X', 'X'),
        charArrayOf('X', 'O', 'O', 'X')
    )
    solve(board)
    board.print()
}

fun solve(board: Array<CharArray>) {
    if (board.isEmpty()) return

    val rows = board.lastIndex
    val cols = board[0].lastIndex

    for (i in 0..cols) {
        floodFill(board, 0, i)
        floodFill(board, rows, i)
    }

    for (i in 0..rows) {
        floodFill(board, i, 0)
        floodFill(board, i, cols)
    }

    board.forEach {
        for (i in it.indices) {
            it[i] = when (it[i]) {
                '$' -> 'O'
                else -> 'X'
            }
        }
    }
}

fun floodFill(board: Array<CharArray>, i: Int, j: Int) {
    if (board.notSafe(i, j) || board[i][j] != 'O')
        return
    board[i][j] = '$'
    floodFill(board, i - 1, j)
    floodFill(board, i + 1, j)
    floodFill(board, i, j - 1)
    floodFill(board, i, j + 1)
}

private fun Array<CharArray>.notSafe(i: Int, j: Int): Boolean {
    return this.getOrNull(i)?.getOrNull(j) == null
}
