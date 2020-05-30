package leetcode.maychallenge.weekone

import utils.println
import java.util.*

fun main() {
    majorityElement(intArrayOf(1)).println()                        // ans: 1
    majorityElement(intArrayOf(3, 2, 3)).println()                  // ans: 3
    majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)).println()      // ans: 2
    majorityElement(intArrayOf(1, 1, 1, 1, 1, 1)).println()         // ans: 1
    majorityElement(intArrayOf(1, 0, 1, 0, 1, 0, 1)).println()      // ans: 1
    majorityElement(intArrayOf(1, 1, 2)).println()                  // ans: 1

    println("====== METHOD 2 =======")

    majorityElement2(intArrayOf(1)).println()                        // ans: 1
    majorityElement2(intArrayOf(3, 2, 3)).println()                  // ans: 3
    majorityElement2(intArrayOf(2, 2, 1, 1, 1, 2, 2)).println()      // ans: 2
    majorityElement2(intArrayOf(1, 1, 1, 1, 1, 1)).println()         // ans: 1
    majorityElement2(intArrayOf(1, 0, 1, 0, 1, 0, 1)).println()      // ans: 1
    majorityElement2(intArrayOf(1, 1, 2)).println()                  // ans: 1
}

// Moore's Voting Algorithm
fun majorityElement(nums: IntArray): Int {
    var count = 0
    var candidate = nums[0]

    nums.forEach {
        if (count == 0)
            candidate = it

        count += if (candidate == it) 1 else -1
    }
    return candidate
}

// Random selection
fun majorityElement2(nums: IntArray): Int {
    val random = Random()
    while (true) {
        val candidate = nums[random.nextInt(nums.size)]
        if (nums.isMajority(candidate))
            return candidate
    }
}

fun IntArray.isMajority(candidate: Int): Boolean {
    var count = 0
    val limit = this.size / 2
    this.forEach {
        if (it == candidate) count++
        if (count > limit)
            return true
    }
    return false
}