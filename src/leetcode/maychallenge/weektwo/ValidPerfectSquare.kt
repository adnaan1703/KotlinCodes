package leetcode.maychallenge.weektwo

import utils.println

fun main() {
    isPerfectSquare(25).println()       // ans: true
    isPerfectSquare(1).println()        // ans: true
    isPerfectSquare(26).println()       // ans: false
    isPerfectSquare(0).println()        // ans: false
    isPerfectSquare(Int.MAX_VALUE).println()  // ans: false

    println("======== METHOD 2 =========")

    isPerfectSquare2(25).println()       // ans: true
    isPerfectSquare2(1).println()        // ans: true
    isPerfectSquare2(26).println()       // ans: false
    isPerfectSquare2(0).println()        // ans: false
    isPerfectSquare2(0).println()        // ans: false
    isPerfectSquare(Int.MAX_VALUE).println()   // ans: false

}

// binary search
fun isPerfectSquare(num: Int): Boolean {
    var low = 1
    var high = 46340

    while (low <= high) {
        val mid = (low + high) shr 1
        val value = mid * mid
        when {
            value == num -> return true
            value > num -> high = mid - 1
            else -> low = mid + 1
        }
    }
    return false
}

// newton's method
fun isPerfectSquare2(num: Int): Boolean {
    if (num == 0) return false

    var sqrt = 46340
    while (sqrt * sqrt > num) {
        sqrt = (sqrt + (num / sqrt)) shr 1
    }
    return sqrt * sqrt == num
}