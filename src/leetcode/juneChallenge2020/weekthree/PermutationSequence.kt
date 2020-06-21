package leetcode.juneChallenge2020.weekthree

import utils.println

fun main() {
    getPermutation(3, 3).println()
    getPermutation(4, 9).println()
}

fun getPermutation(n: Int, k: Int): String {
    var value = 1L
    val stringBuilder = StringBuilder()
    val digits = ArrayList<Int>(); for (i in 1..n) digits.add(i)
    val factorial = LongArray(n + 1) { i ->
        when (i) {
            0 -> 1
            else -> {
                value *= i
                value
            }
        }
    }

    for (i in n downTo 1) {
        val pos = ((k - 1) % factorial[i]) / factorial[i - 1]
        stringBuilder.append(digits[pos.toInt()])
        digits.removeAt(pos.toInt())
    }

    return stringBuilder.toString()
}


