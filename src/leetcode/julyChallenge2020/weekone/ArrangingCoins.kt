package leetcode.julyChallenge2020.weekone

import utils.println
import kotlin.math.sqrt

fun main() {
    arrangeCoins(5).println()
    arrangeCoins(8).println()
    arrangeCoins(1804289383).println()
}

fun arrangeCoins(n: Int): Int {
    return ((sqrt(1.0 + 8 * n.toLong()) - 1) / 2.0).toInt()
}