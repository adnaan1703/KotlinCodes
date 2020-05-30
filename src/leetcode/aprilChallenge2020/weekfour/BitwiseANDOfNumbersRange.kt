package leetcode.aprilChallenge2020.weekfour

import kotlin.math.pow

fun main() {
    println(rangeBitwiseAnd(5, 7))      // ans: 4
    println(rangeBitwiseAnd(0, 1))      // ans: 0
    println(rangeBitwiseAnd(9, 15))     // ans: 8
    println(rangeBitwiseAnd(12, 14))    // ans: 12
    println(rangeBitwiseAnd(14, 14))    // ans: 14

    println(rangeBitwiseAnd2(5, 7))      // ans: 4
    println(rangeBitwiseAnd2(0, 1))      // ans: 0
    println(rangeBitwiseAnd2(9, 15))     // ans: 8
    println(rangeBitwiseAnd2(12, 14))    // ans: 12
    println(rangeBitwiseAnd2(14, 14))    // ans: 14
}

fun rangeBitwiseAnd(lower: Int, upper: Int): Int {

    var m = lower
    var n = upper

    val diff: Double = (n - m).toDouble()

    var ans = 0
    var i = 0

    while (n > 0) {
        val lsb1 = m and 1
        val lsb2 = n and 1

        var lsbAns = lsb1 and lsb2

        if (lsbAns == 1 && diff > 2.0.pow(i)) {
            lsbAns = 0
        }

        if (lsbAns == 1) ans = setBitAt(ans, i)

        m = m shr 1
        n = n shr 1
        i++
    }
    return ans
}

fun setBitAt(num: Int, pos: Int): Int {
    val mask = 1 shl pos
    return num or mask
}


// faster
fun rangeBitwiseAnd2(m: Int, n: Int): Int {
    var lower = m
    var upper = n
    var counter = 0
    while (lower != upper) {
        lower = lower shr 1
        upper = upper shr 1
        counter++
    }
    return upper shl counter
}