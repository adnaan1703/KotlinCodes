package leetcode.mayChallenge2020.weekfour

import utils.print
import kotlin.math.max
import kotlin.math.min

fun main() {
    val a = arrayOf(intArrayOf(0, 2), intArrayOf(5, 10), intArrayOf(13, 23), intArrayOf(24, 25))
    val b = arrayOf(intArrayOf(1, 5), intArrayOf(8, 12), intArrayOf(15, 24), intArrayOf(25, 26))
    intervalIntersection(a, b).print()
}

    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
        var i = 0
        var j = 0

        val ans = mutableListOf<IntArray>()

        while (i < A.size && j < B.size) {
            val l = max(A[i][0], B[j][0])
            val r = min(A[i][1], B[j][1])

            if (l <= r) ans.add(intArrayOf(l, r))
            if (r == A[i][1]) i++ else j++
        }
        return ans.toTypedArray()
    }
