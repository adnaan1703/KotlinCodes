package leetcode.thirtydaychallenge.weekthree

private class BinaryMatrix(val grid: Array<IntArray>) {
    fun get(x: Int, y: Int): Int {
        return grid[x][y]
    }

    fun dimensions(): List<Int> {
        return listOf(grid.size, grid[0].size)
    }
}

fun main() {
    var grid = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(1, 1)
    )
    println(leftMostColumnWithOne(BinaryMatrix(grid)))      // ans: 0

    grid = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(0, 0)
    )
    println(leftMostColumnWithOne(BinaryMatrix(grid)))      // ans: -1

    grid = arrayOf(
        intArrayOf(0, 0, 0, 1),
        intArrayOf(0, 0, 1, 1),
        intArrayOf(0, 1, 1, 1)
    )
    println(leftMostColumnWithOne(BinaryMatrix(grid)))      // ans: 1

    grid = arrayOf(
        intArrayOf(0, 0, 1, 1),
        intArrayOf(0, 1, 1, 1),
        intArrayOf(0, 0, 0, 1),
        intArrayOf(0, 0, 0, 0)
    )

    println(leftMostColumnWithOne(BinaryMatrix(grid)))      // ans: 1

}

private fun leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int {
    var ans = -1
    val dimens: List<Int> = binaryMatrix.dimensions()
    var row = 0
    var col = dimens[1] - 1

    while (col in 0 until dimens[1] && row in 0 until dimens[0]) {
        row = binaryMatrix.goDown(row, col, dimens[0] - 1)
        col = binaryMatrix.goLeft(row, col)
        ans = if (col != -1) col else ans
        row++
    }
    return ans
}

private fun BinaryMatrix.safeGet(row: Int, col: Int): Int {
    if (row >= 0 && col >= 0)
        return this.get(row, col)
    return 0
}

private fun BinaryMatrix.goDown(row: Int, col: Int, n: Int): Int {
    var ans = row
    while (ans <= n) {
        if (this.get(ans, col) == 1)
            return ans
        ans++
    }
    return -1
}

private fun BinaryMatrix.goLeft(row: Int, col: Int): Int {

    if (row == -1 || col == -1)
        return -1

    var low = 0
    var high = col

    while (low in 0..high && high >= 0) {
        val mid = (low + high) shr 1
        val curr = this.safeGet(row, mid)
        val prev = this.safeGet(row, mid - 1)

        if (curr == 1 && prev == 0)
            return mid

        if (curr == 1)
            high = mid - 1
        else
            low = mid + 1
    }
    return -1
}