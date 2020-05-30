package leetcode.maychallenge.weekfour

import utils.printWithSpace

fun main() {
    countBits(5).printWithSpace()
    countBits(0).printWithSpace()
    countBits(1).printWithSpace()
    countBits(2).printWithSpace()
}

fun countBits(num: Int): IntArray {
    val arr = IntArray(num + 1)
    var space = -1

    for (i in 1..num) {
        if (i and (i - 1) == 0) space = i
        arr[i] = arr[i - space] + 1
    }
    return arr
}