package leetcode.mayChallenge2020.weektwo

import utils.println
import java.util.*

fun main() {
    removeKdigits("1432219", 3).println()
    removeKdigits("10200", 1).println()
    removeKdigits("10", 2).println()
}

fun removeKdigits(num: String, k: Int): String {
    var limit: Int = k
    val stack = Stack<Char>()

    num.forEach { char ->
        if (stack.isNotEmpty()) {
            while (limit > 0 && stack.isNotEmpty() && char < stack.peek()) {
                stack.pop()
                limit--
            }
        }
        stack.push(char)
    }

    while (limit > 0 && stack.isNotEmpty()) {
        stack.pop()
        limit--
    }

    var ans = ""
    var includeZeroes = false
    stack.forEach {
        if (it != '0')
            includeZeroes = true

        if (it != '0' || includeZeroes)
            ans += it
    }
    return if (ans.isBlank()) "0" else ans
}
