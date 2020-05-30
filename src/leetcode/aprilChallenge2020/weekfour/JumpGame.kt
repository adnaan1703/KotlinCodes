package leetcode.aprilChallenge2020.weekfour

import kotlin.math.max

fun main() {
    println(canJump(intArrayOf(2, 3, 1, 1, 4)))     // ans: true
    println(canJump(intArrayOf(3, 2, 1, 0, 4)))     // ans: false
}

fun canJump(nums: IntArray): Boolean {
    var farthest = 0

    for ((index, value) in nums.withIndex()) {
        if (index > farthest)
            return false
        farthest = max(farthest, value + index)
    }
    return true
}