package leetcode.maychallenge.weekone

import utils.print

fun main() {
    val versionControl = VersionControl(2126753390, 1702766719)
    versionControl.firstBadVersion(2126753390).print()
}

private class VersionControl(n: Int, m: Int) {
    val arr: BooleanArray = BooleanArray(n) { i -> i + 1 >= m }

    fun isBadVersion(index: Int): Boolean {
        return arr[index - 1]
    }

    fun firstBadVersion(n: Int): Int {
        var low = 1L
        var high: Long = n.toLong()
        while (low <= high) {
            val mid: Long = (low + high) shr 1
            val statusMid = isBadVersion(mid.toInt())
            val statusPrev = if (mid == 1L) false else isBadVersion((mid - 1).toInt())

            if (statusMid && !statusPrev)
                return mid.toInt()
            else if (!statusMid) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }
        return 0
    }
}

