package leetcode.juneChallenge2020.weekfour

import utils.println

fun main() {
    findDuplicate(intArrayOf(1, 3, 4, 2, 2)).println()
    findDuplicate(intArrayOf(3, 1, 3, 4, 2)).println()
    findDuplicate(intArrayOf(1, 1)).println()
}

fun findDuplicate(nums: IntArray): Int {
    var fast = nums[0]
    var slow = nums[0]

    do {
        fast = nums[nums[fast]]
        slow = nums[slow]
    } while (fast != slow)

    slow = nums[0]
    while (fast != slow) {
        fast = nums[fast]
        slow = nums[slow]
    }
    return slow
}