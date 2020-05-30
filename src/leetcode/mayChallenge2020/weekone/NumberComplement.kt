package leetcode.mayChallenge2020.weekone

import utils.println
import kotlin.math.floor
import kotlin.math.log2
import kotlin.math.pow

fun main() {
    findComplement(5).println()             // ans: 2
    findComplement(4).println()             // ans: 3
    findComplement(1).println()             // ans: 0
    findComplement(7).println()             // ans: 0
    findComplement(Int.MAX_VALUE).println()       // ans: 0

    println("======== METHOD 2 =========")

    findComplement2(5).println()             // ans: 2
    findComplement2(4).println()             // ans: 3
    findComplement2(1).println()             // ans: 0
    findComplement2(7).println()             // ans: 0
    findComplement2(Int.MAX_VALUE).println()       // ans: 0
}

fun findComplement2(num: Int): Int {
    val leadingZeroes = Integer.numberOfLeadingZeros(num)
    return num.inv().shl(leadingZeroes).shr(leadingZeroes)
}

fun findComplement(num: Int): Int {
    val basePower: Double = floor(log2(num.toDouble()))
    val baseNumber: Long = 2.0.pow(basePower + 1.0).toLong() - 1
    val ans = num.toLong() xor baseNumber
    return ans.toInt()
}