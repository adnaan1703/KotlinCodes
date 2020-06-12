package leetcode.juneChallenge2020.weektwo

import utils.printWithSpace

fun main() {
    var color = intArrayOf(2, 0, 2, 1, 1, 0)
//    sortColors(color)
    color.printWithSpace()
    color = intArrayOf(1, 2, 0)
    sortColors(color)
    color.printWithSpace()
}

/*
 * Classic Dutch Flag Problem
 * http://users.monash.edu/~lloyd/tildeAlgDS/Sort/Flag/
 */

fun sortColors(nums: IntArray) {
    var low = 0
    var mid = 0
    var high = nums.lastIndex

    while (mid <= high) {
        when (nums[mid]) {
            0 -> nums.swap(low++, mid++)
            1 -> mid++
            2 -> nums.swap(mid, high--)
        }
    }
}

private fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}