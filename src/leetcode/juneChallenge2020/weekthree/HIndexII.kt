package leetcode.juneChallenge2020.weekthree

import utils.println

fun main() {
    hIndex(intArrayOf(0, 1, 3, 5, 6)).println()
    hIndex(intArrayOf(0, 1, 1, 1)).println()
    hIndex(intArrayOf(0, 3, 3, 3)).println()
    hIndex(intArrayOf(3, 3, 3)).println()
    hIndex(intArrayOf(0, 0, 0, 0)).println()
    hIndex(intArrayOf(4)).println()
    hIndex(intArrayOf()).println()
}

fun hIndex(citations: IntArray): Int {
    if (citations.isEmpty()) return 0

    var low = 0
    var high = citations.lastIndex
    while (low <= high) {
        val mid = low + (high - low) / 2
        val current = citations.isMarked(mid)
        val prev = citations.isMarked(mid - 1)
        when {
            current && prev.not() -> return citations.size - mid
            current && prev -> high = mid - 1
            else -> low = mid + 1
        }
    }
    return 0
}

private fun IntArray.isMarked(index: Int): Boolean {
    if (index < 0)
        return false
    return this.size - index <= this[index]
}