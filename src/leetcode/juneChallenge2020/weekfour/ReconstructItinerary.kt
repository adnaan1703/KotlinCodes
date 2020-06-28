package leetcode.juneChallenge2020.weekfour

import utils.print
import java.util.*
import kotlin.collections.HashMap

fun main() {
    var tickets = listOf(
        listOf("MUC", "LHR"),
        listOf("JFK", "MUC"),
        listOf("SFO", "SJC"),
        listOf("LHR", "SFO")
    )
    findItinerary(tickets).print()

    tickets = listOf(
        listOf("JFK", "SFO"),
        listOf("JFK", "ATL"),
        listOf("SFO", "ATL"),
        listOf("ATL", "JFK"),
        listOf("ATL", "SFO")
    )
    findItinerary(tickets).print()

    tickets = listOf(
        listOf("JFK", "C"),
        listOf("C", "JFK"),
        listOf("JFK", "B")
    )
    findItinerary(tickets).print()
}

fun findItinerary(tickets: List<List<String>>): List<String> {
    val map = HashMap<String, PriorityQueue<String>>()
    val ans = LinkedList<String>()

    tickets.forEach {
        map.computeIfAbsent(it[0]) { PriorityQueue<String>() }.add(it[1])
    }
    dfs(map, ans, "JFK");
    return ans;
}

fun dfs(map: HashMap<String, PriorityQueue<String>>, ans: LinkedList<String>, current: String) {
    while (map.get(current)?.isNotEmpty() ?: false) {
        dfs(map, ans, map.get(current)!!.poll())
    }
    ans.addFirst(current)
}