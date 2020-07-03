package leetcode.julyChallenge2020.weekone

import utils.printWithSpace

fun main() {
    prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 7).printWithSpace()
    prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 1000000000).printWithSpace()
}

/*
 * For some reason across many of my test cases pivot is always coming as 1
 * and modulo as 14. Maybe this could be the property of the problem but I can't
 * prove this mathematically right now. Hence going with bit of more generic solution.
 */

fun prisonAfterNDays(cells: IntArray, N: Int): IntArray {
    if (N == 0)
        return cells

    var changingCells = cells
    var index = -1
    var num = changingCells.toInt()
    val indexHashMap = mutableMapOf<Int, Int>()
    val hashMap = mutableMapOf<Int, IntArray>()

    while (indexHashMap.containsKey(num).not()) {
        hashMap[++index] = changingCells
        indexHashMap[num] = index

        changingCells = changingCells.change()
        num = changingCells.toInt()
    }

    val pivot: Int = indexHashMap[num]!!
    val modulo = index - pivot + 1
    val ansPtr = ((N - pivot) % modulo) + pivot
    return hashMap[ansPtr]!!
}

fun IntArray.change(): IntArray {
    val temp = IntArray(this.size)
    for (i in 1..6) {
        temp[i] = if (this[i - 1] == this[i + 1]) 1 else 0
    }
    return temp
}

fun IntArray.toInt(): Int {
    var num = 0
    this.forEach {
        num = num shl 1
        num = num or it
    }
    return num
}

