package leetcode.juneChallenge2020.weekone

import utils.println
import kotlin.math.abs

fun main() {
    val costs = arrayOf(
        intArrayOf(10, 20),
        intArrayOf(30, 200),
        intArrayOf(400, 50),
        intArrayOf(30, 20)
    )
    twoCitySchedCost(costs).println()
}

fun twoCitySchedCost(costs: Array<IntArray>): Int {
    val n = costs.size / 2

    var cityACount = 0
    var cityBCount = 0
    var ans = 0

    costs.sortWith(compareByDescending { abs(it[0] - it[1]) })

    var i = 0
    while (i <= costs.lastIndex && cityACount < n && cityBCount < n) {
        val it = costs[i]
        ans += if (it[0] < it[1]) {
            cityACount++
            it[0]
        } else {
            cityBCount++
            it[1]
        }
        i++
    }

    while (cityACount < n && i < costs.size) {
        cityACount++
        ans += costs[i][0]
        i++
    }

    while (cityBCount < n && i < costs.size) {
        cityBCount++
        ans += costs[i][1]
        i++
    }
    return ans
}