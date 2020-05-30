package leetcode.maychallenge.weektwo

import utils.print

fun main() {
    val image = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 0, 1)
    )
    floodFill(image, 1, 1, 2)
    image.print()
}

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
    if (image[sr][sc] != newColor)
        floodFillRecursive(image, sr, sc, newColor, image[sr][sc])
    return image
}

fun floodFillRecursive(image: Array<IntArray>, i: Int, j: Int, newColor: Int, currentColor: Int) {
    if (image.outRange(i, j) || image[i][j] != currentColor)
        return

    image[i][j] = newColor
    floodFillRecursive(image, i - 1, j, newColor, currentColor)
    floodFillRecursive(image, i + 1, j, newColor, currentColor)
    floodFillRecursive(image, i, j - 1, newColor, currentColor)
    floodFillRecursive(image, i, j + 1, newColor, currentColor)
}

fun Array<IntArray>.outRange(i: Int, j: Int): Boolean {
    return (i < 0 || i > this.lastIndex || j < 0 || j > this[i].lastIndex)
}