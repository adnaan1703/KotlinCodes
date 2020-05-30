package leetcode.maychallenge.weektwo

import utils.println

fun main() {
    singleNonDuplicate(intArrayOf(1, 1, 2, 3, 3, 4, 4, 8, 8)).println()     // ans: 2
    singleNonDuplicate(intArrayOf(3, 3, 7, 7, 10, 11, 11)).println()        // ans: 10
    singleNonDuplicate(intArrayOf(3, 3, 7, 7, 11, 11, 12)).println()        // ans: 12
    singleNonDuplicate(intArrayOf(3, 7, 7, 10, 10, 11, 11)).println()       // ans: 3
}

    fun singleNonDuplicate(nums: IntArray): Int {
        var low = 0
        var high = nums.lastIndex

        while (low <= high) {
            val mid = low + (high - low) / 2
            when {
                nums.isAns(mid) -> return nums[mid]
                nums.checkLeft(mid) -> low = mid + 1
                else -> high = mid - 1
            }
        }
        return -1
    }

    fun IntArray.isAns(index: Int): Boolean {
        return this[index] != this.getOrNull(index - 1) && this[index] != this.getOrNull(index + 1)
    }

    fun IntArray.checkLeft(index: Int): Boolean {
        return when (index % 2) {
            0 -> this[index] == this.getOrNull(index + 1)
            else -> this[index] == this.getOrNull(index - 1)
        }
    }
