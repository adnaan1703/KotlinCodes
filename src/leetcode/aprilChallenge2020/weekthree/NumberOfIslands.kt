package leetcode.aprilChallenge2020.weekthree

fun main() {
    var input = arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )

    println(numIslands(input))      // ans: 1

    input = arrayOf(
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '1', '0', '0'),
        charArrayOf('0', '0', '0', '1', '1')
    )

    println(numIslands(input))      // ans: 3
}

fun numIslands(grid: Array<CharArray>): Int {
    var counter = 0

    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid.isLand(i, j)) {
                counter++
                countRecursively(i, j, grid)
            }
        }
    }
    return counter
}

fun countRecursively(i: Int, j: Int, grid: Array<CharArray>) {
    grid[i][j] = '2'

    for (row in -1..1 step 2) {
        if (grid.isLand(i + row, j)) {
            countRecursively(i + row, j, grid)
        }
    }

    for (col in -1..1 step 2) {
        if (grid.isLand(i, j + col)) {
            countRecursively(i, j + col, grid)
        }
    }
}

fun Array<CharArray>.isLand(i: Int, j: Int): Boolean {
    val value = this.getOrNull(i)?.getOrNull(j) ?: '0'
    return value == '1'
}
