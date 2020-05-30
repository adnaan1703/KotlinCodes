package leetcode.mayChallenge2020.weekfour

import utils.println
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    var dislikes: Array<IntArray> = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(2, 4)
    )
    possibleBiPartition(4, dislikes).println()

    dislikes = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(1, 3),
        intArrayOf(2, 3)
    )
    possibleBiPartition(3, dislikes).println()

    dislikes = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(1, 5)
    )
    possibleBiPartition(5, dislikes).println()
}

fun possibleBiPartition(N: Int, dislikes: Array<IntArray>): Boolean {

    val graph: Array<ArrayList<Int>> = Array(N + 1) { ArrayList<Int>() }
    dislikes.forEach { ints ->
        val p1 = ints[0]
        val p2 = ints[1]
        graph[p1].add(p2)
        graph[p2].add(p1)
    }

    val colors: Array<Int> = Array(N + 1) { 0 }

    (1..graph.lastIndex).forEach {
        if (colors[it] == 0) {
            if (!bfs(graph, colors, it))
                return false
        }
    }
    return true
}

fun bfs(graph: Array<ArrayList<Int>>, colors: Array<Int>, source: Int): Boolean {
    val queue: Queue<Int> = LinkedList()
    var currColor = -1
    colors[source] = currColor
    queue.offer(source)

    while (queue.isNotEmpty()) {
        val value = queue.poll()
        graph[value].forEach {
            currColor = colors[value] * -1
            if (colors[it] == 0) {
                colors[it] = currColor
                queue.offer(it)
            } else if (colors[it] == -1 * currColor)
                return false
        }
    }
    return true
}