package leetcode.mayChallenge2020.weekthree

import utils.println
import kotlin.math.max

fun main() {
    maxSubarraySumCircular(intArrayOf(1, -2, 3, -2)).println()      // ans: 3
    maxSubarraySumCircular(intArrayOf(5, -3, 5)).println()          // ans: 10
    maxSubarraySumCircular(intArrayOf(3, -1, 2, -1)).println()      // ans: 4
    maxSubarraySumCircular(intArrayOf(3, -2, 2, -3)).println()      // ans: 3
    maxSubarraySumCircular(intArrayOf(-2, -3, -1)).println()        // ans: -1
}

    fun maxSubarraySumCircular(arr: IntArray): Int {
        val kadaneMax = findMaxWithKadane(arr)
        var hasPositive = false
        var sum = 0
        arr.forEachIndexed { index, it ->
            hasPositive = hasPositive || it > 0
            sum += it
            arr[index] = -arr[index]
        }
        return if (hasPositive) max(kadaneMax, sum + findMaxWithKadane(arr)) else kadaneMax
    }

    fun findMaxWithKadane(arr: IntArray): Int {
        var ans = Int.MIN_VALUE
        var sum = 0
        arr.forEach {
            sum += it
            ans = max(ans, sum)
            if (sum <= 0)
                sum = 0
        }
        return ans
    }