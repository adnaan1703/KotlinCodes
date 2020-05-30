package leetcode.maychallenge.weekthree

import java.util.*

fun main() {
    val stockSpanner = StockSpanner()
    intArrayOf(100, 80, 60, 70, 60, 75, 85).forEach { stockSpanner.next(it) }
}

private class StockSpanner {

    val stack = Stack<Pair<Int, Int>>()
    var counter = -1

    init {
        stack.push(Int.MAX_VALUE to -1)
    }

    fun next(price: Int): Int {
        counter++

        while (stack.peek().first <= price) stack.pop()

        val ans = counter - stack.peek().second
        stack.push(price to counter)
        return ans
    }
}
