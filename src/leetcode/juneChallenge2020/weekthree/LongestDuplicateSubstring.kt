package leetcode.juneChallenge2020.weekthree

import utils.println
import kotlin.math.pow

@Suppress("SpellCheckingInspection")
fun main() {
    longestDupSubstring("banana").println()
    longestDupSubstring("axaxaxaxax").println()
}

fun longestDupSubstring(S: String): String {
    val nums = LongArray(S.length) { i -> S[i].toLong() }
    var low = 1
    var high = S.length
    while (low != high) {
        val mid = low + (high - low) / 2
        if (search(mid, nums) != -1) low = mid + 1
        else high = mid
    }

    val index = search(low - 1, nums)
    return if (index != -1) S.substring(index, index + low - 1) else ""
}

private fun search(length: Int, nums: LongArray): Int {
    val base = 26L
    val modulus: Long = 2.0.pow(32).toLong()
    val hashSet: HashSet<Long> = HashSet()
    var hash = 0L
    for (i in 0 until length) hash = (hash * base + nums[i]) % modulus
    hashSet.add(hash)

    var hashPow = 1L
    for (i in 1..length) hashPow = (hashPow * base) % modulus

    for (i in 1 until nums.size - length + 1) {
        hash = (hash * base - nums[i - 1] * hashPow % modulus + modulus) % modulus
        hash = (hash + nums[i + length - 1]) % modulus
        if (hashSet.contains(hash)) return i
        hashSet.add(hash)
    }
    return -1
}