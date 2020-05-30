package leetcode.thirtydaychallenge.weektwo

import kotlin.math.max

fun main() {
    println(findMaxLength(intArrayOf(0, 1)))
    println(findMaxLength(intArrayOf(0, 1, 0)))
    println(findMaxLength(intArrayOf(0, 0, 0)))
    println(findMaxLength(intArrayOf(1, 1, 1)))
    println(findMaxLength(intArrayOf(1, 1, 1, 1, 0, 1, 0, 0, 1)))
    println(findMaxLength(intArrayOf(1, 0, 1, 1, 1, 1, 0)))
    println(findMaxLength(intArrayOf(1, 0, 1, 1, 1, 1, 0, 0, 0)))
}

fun findMaxLength(nums: IntArray): Int {
    var cSum = 0
    var ans = 0
    val map: HashMap<Int, Int> = HashMap()
    map[0] = -1

    for ((index, value) in nums.withIndex()) {
        cSum += if (value == 1) 1 else -1
        if (map.containsKey(cSum)) {
            ans = max(ans, index - map[cSum]!!)
        } else {
            map[cSum] = index
        }
    }
    return ans
}

