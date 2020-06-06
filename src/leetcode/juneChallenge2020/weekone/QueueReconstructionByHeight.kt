package leetcode.juneChallenge2020.weekone

import utils.print

fun main() {
    val people = arrayOf(
        intArrayOf(7, 0),
        intArrayOf(4, 4),
        intArrayOf(7, 1),
        intArrayOf(5, 0),
        intArrayOf(6, 1),
        intArrayOf(5, 2)
    )
    reconstructQueue(people).print()
}

fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    people.sortWith(compareBy({ it[0] }, { it[1] }))
    val ans = Array(people.size) { intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE) }
    people.forEach { ints ->
        var steps = ints[1] + 1
        var i = -1
        while (steps > 0) {
            i++
            if (ans[i][0] >= ints[0])
                steps--
        }
        ans[i] = ints
    }
    return ans
}