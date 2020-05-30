package leetcode.mayChallenge2020.weektwo

import utils.println

fun main() {
    var trust = arrayOf(
        intArrayOf(1, 2)
    )
    findJudge(2, trust).println()       // ans: 2

    trust = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3)
    )
    findJudge(3, trust).println()       // ans: 3

    trust = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(3, 1)
    )
    findJudge(3, trust).println()       // ans: -1

    trust = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3)
    )
    findJudge(3, trust).println()       // ans: -1

    trust = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(1, 4),
        intArrayOf(2, 3),
        intArrayOf(2, 4),
        intArrayOf(4, 3)
    )
    findJudge(4, trust).println()       // ans: 3
}


fun findJudge(N: Int, trust: Array<IntArray>): Int {
    val trustCount = IntArray(N)

    trust.forEach {
        trustCount[it[0] - 1]--
        trustCount[it[1] - 1]++
    }

    trustCount.forEachIndexed { index, itr ->
        if (itr == N - 1)
            return index + 1
    }
    return -1
}