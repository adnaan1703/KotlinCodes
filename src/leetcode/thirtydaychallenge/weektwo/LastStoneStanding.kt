package leetcode.thirtydaychallenge.weektwo

import java.util.*

fun main() {
    println(lastStoneWeight(intArrayOf(2, 7, 4, 1, 8, 1)))
    println(lastStoneWeight(intArrayOf(5, 5)))
}

fun lastStoneWeight(stones: IntArray): Int {
    val heap: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
    for (itr in stones) {
        heap.add(itr)
    }

    while (heap.size >= 2) {
        val bigStone: Int = heap.poll()
        val smallStone: Int = heap.poll()

        if (bigStone > smallStone) {
            heap.add(bigStone - smallStone)
        }
    }
    return if (heap.size == 1) heap.peek() else 0
}