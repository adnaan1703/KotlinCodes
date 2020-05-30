package leetcode.mayChallenge2020.weekfive

import utils.println
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    var courses = arrayOf(intArrayOf(1, 0))
    canFinish(2, courses).println()                         // ans: true

    courses = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))
    canFinish(2, courses).println()                         // ans: false

    courses = arrayOf(intArrayOf(1, 0), intArrayOf(1, 2), intArrayOf(0, 1))
    canFinish(3, courses).println()                         // ans: false

    courses = arrayOf(
        intArrayOf(3, 1),
        intArrayOf(1, 2),
        intArrayOf(1, 0)
    )
    canFinish(4, courses).println()                     // ans: true

    courses = arrayOf(
        intArrayOf(3, 1),
        intArrayOf(1, 2),
        intArrayOf(1, 0),
        intArrayOf(0, 3)
    )
    canFinish(4, courses).println()                 // ans: false

    courses = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(2, 6),
        intArrayOf(1, 7),
        intArrayOf(5, 1),
        intArrayOf(6, 4),
        intArrayOf(7, 0),
        intArrayOf(0, 5)
    )
    canFinish(8, courses).println()             // ans: false
}

fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val graph = Array(numCourses) { ArrayList<Int>() }
    val inDegrees = IntArray(numCourses)

    prerequisites.forEach {
        graph[it[1]].add(it[0])
        inDegrees[it[0]]++
    }

    val q: Queue<Int> = LinkedList<Int>()
    inDegrees.forEachIndexed { index, i ->
        if (i == 0)
            q.offer(index)
    }

    while (q.isNotEmpty()) {
        val node = q.poll()
        graph[node].forEach {
            inDegrees[it]--
            if (inDegrees[it] == 0)
                q.offer(it)
        }
    }

    inDegrees.forEach { if (it != 0) return false }
    return true
}

// using dfs to track back edge
fun canFinish2(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
    val graph = Array(numCourses) { ArrayList<Int>() }
    val visited = BooleanArray(numCourses) { false }

    prerequisites.forEach { ints ->
        graph[ints[1]].add(ints[0])
    }

    for (i in visited.indices) {
        if (visited[i].not()) {
            if (dfsNoCycle(graph, i, BooleanArray(numCourses), visited).not())
                return false
        }
    }
    return true
}

fun dfsNoCycle(graph: Array<ArrayList<Int>>, source: Int, inStack: BooleanArray, visited: BooleanArray): Boolean {
    var retValue = true
    if (inStack[source])
        return false

    visited[source] = true
    inStack[source] = true

    graph[source].forEach {
        if (inStack[it])
            return false

        if (visited[it].not())
            retValue = retValue && dfsNoCycle(graph, it, inStack, visited)
    }
    inStack[source] = false
    return retValue
}
