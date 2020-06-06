package leetcode.juneChallenge2020.weekone

import utils.println
import java.util.*
import kotlin.random.Random

class RandomPickWithWeight(w: IntArray) {
    private val tree = TreeSet<Pair<Int, Int>> { o1, o2 -> o1.first - o2.first }
    private val totalSum: Int

    init {
        var sum = 0
        w.forEachIndexed { index, it ->
            sum += it
            tree.add(sum to index)
        }
        totalSum = sum
    }

    fun pickIndex(): Int {
        return tree.ceiling(Random.nextInt(1, totalSum + 1) to 0)!!.second
    }
}

fun main() {
    val obj = RandomPickWithWeight(intArrayOf(3, 14, 1, 7))
    obj.pickIndex().println()
    obj.pickIndex().println()
    obj.pickIndex().println()
    obj.pickIndex().println()
    obj.pickIndex().println()
    obj.pickIndex().println()
    obj.pickIndex().println()
    obj.pickIndex().println()
    obj.pickIndex().println()
    obj.pickIndex().println()
}