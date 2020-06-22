package leetcode.juneChallenge2020.weekfour

import utils.println

fun main() {
    singleNumber(intArrayOf(2, 2, 3, 2)).println()
    singleNumber(intArrayOf(0, 1, 0, 1, 0, 1, 99)).println()
}

/*
 * Couldn't solve myself: A good resource to understand this:
 * https://medium.com/@lenchen/leetcode-137-single-number-ii-31af98b0f462
 */
@Suppress("SpellCheckingInspection")
fun singleNumber(nums: IntArray): Int {

    // l' = ~h & (l ^ i)
    var lowBits = 0

    // h' = ~l' & (h ^ i)
    var hightBits = 0

    nums.forEach {
        lowBits = hightBits.inv() and lowBits.xor(it)
        hightBits = lowBits.inv() and hightBits.xor(it)
    }
    return lowBits
}