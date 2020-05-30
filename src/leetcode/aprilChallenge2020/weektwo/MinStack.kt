package leetcode.aprilChallenge2020.weektwo

import java.util.*
import kotlin.math.min

private class MinStack {
    val stack: Stack<MinStackNode> = Stack()

    fun push(x: Int) {
        val min = if (stack.empty()) x else min(x, stack.peek().min)
        stack.push(MinStackNode(x, min))
    }

    fun pop() {
        stack.pop()
    }

    fun top(): Int {
        return stack.peek().value
    }

    fun getMin(): Int {
        return stack.peek().min
    }

    private data class MinStackNode(val value: Int, val min: Int)
}

fun main() {

    val minStack = MinStack()
    minStack.push(-2)
    minStack.push(0)
    minStack.push(-3)
    println(minStack.getMin())      // outputs: -3
    minStack.pop()
    println(minStack.top())         // outputs: 0
    println(minStack.getMin())      // outputs: -2
}