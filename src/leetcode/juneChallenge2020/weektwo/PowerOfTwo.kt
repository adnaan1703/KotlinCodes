package leetcode.juneChallenge2020.weektwo

import utils.println

fun main() {
    isPowerOfTwo(-8).println()
    isPowerOfTwo(0).println()
    isPowerOfTwo(8).println()
    isPowerOfTwo(7).println()
}

fun isPowerOfTwo(n: Int): Boolean {
    return n > 0 && n and n - 1 == 0
}
