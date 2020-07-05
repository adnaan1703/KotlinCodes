package leetcode.julyChallenge2020.weekone

import utils.println

fun main() {
    hammingDistance(1, 4).println()
    hammingDistance(3, 5).println()
    hammingDistance(3, 7).println()
}

fun hammingDistance(x: Int, y: Int): Int {
    var xored = x xor y
    var count = 0
    while (xored > 0) {
        count += xored and 1
        xored = xored shr 1
    }
    return count
}