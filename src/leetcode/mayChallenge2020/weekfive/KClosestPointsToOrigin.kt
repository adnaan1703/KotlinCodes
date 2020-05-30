package leetcode.mayChallenge2020.weekfive

import utils.print
import java.util.*

fun main() {
    var points = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(-2, 2)
    )
    kClosest(points, 1).print()

    points = arrayOf(
        intArrayOf(3, 3),
        intArrayOf(5, -1),
        intArrayOf(-2, 4)
    )
    kClosest(points, 2).print()
}


fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
    val maxHeap = PriorityQueue<IntArray>(K) { o1, o2 -> o2.compare(o1) }
    points.forEach {
        if (maxHeap.size < K) {
            maxHeap.add(it)
        } else if (maxHeap.size >= K && maxHeap.peek()!!.compare(it) > 0) {
            maxHeap.poll()
            maxHeap.add(it)
        }
    }

    val ans: Array<IntArray> = Array(maxHeap.size) { IntArray(2) }
    return maxHeap.toArray(ans)
}

fun IntArray.compare(obj: IntArray): Int {
    return ((this[0] * this[0]) + (this[1] * this[1])) - ((obj[0] * obj[0]) + (obj[1] * obj[1]))
}