package leetcode.juneChallenge2020.weektwo

import utils.println

fun main() {
    searchInsert(intArrayOf(1, 3, 5, 6), 5).println()
    searchInsert(intArrayOf(1, 3, 5, 6), 2).println()
    searchInsert(intArrayOf(1, 3, 5, 6), 7).println()
    searchInsert(intArrayOf(1, 3, 5, 6), 0).println()
    searchInsert(intArrayOf(1, 3, 5, 6), 1).println()
    searchInsert(intArrayOf(1, 3, 5, 6), 6).println()
    searchInsert(intArrayOf(1, 3, 5, 8), 7).println()
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var low = 0
    var high = nums.lastIndex

    while (low <= high) {
        val mid = low + (high - low) / 2
        when {
            nums[mid] == target -> return mid
            nums[mid] > target -> high = mid - 1
            else -> low = mid + 1
        }
    }
    return low
}
