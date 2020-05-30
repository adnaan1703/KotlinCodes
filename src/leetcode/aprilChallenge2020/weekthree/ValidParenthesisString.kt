package leetcode.aprilChallenge2020.weekthree

import java.util.*

fun main() {
    println(checkValidString(""))               // ans: true
    println(checkValidString("()"))             // ans: true
    println(checkValidString("(*)"))            // ans: true
    println(checkValidString("(*))"))           // ans: true
    println(checkValidString("((*)"))           // ans: true
    println(checkValidString("*"))              // ans: true
    println(checkValidString("**(*"))           // ans: true
    println(checkValidString("((****()"))       // ans: true

    println(checkValidString("((*"))            // ans: false
    println(checkValidString("(*)(*)((*"))      // ans: false
}

fun checkValidString(s: String): Boolean {
    val bDeque: LinkedList<Int> = LinkedList()
    val sDeque: LinkedList<Int> = LinkedList()

    for ((i, c) in s.withIndex()) {
        when (c) {
            '(' -> bDeque.offerLast(i)
            '*' -> sDeque.offerLast(i)
            else -> {
                when {
                    bDeque.size > 0 -> bDeque.pollLast()
                    sDeque.size > 0 -> sDeque.pollFirst()
                    else -> return false
                }
            }
        }
    }

    while (bDeque.isEmpty().not()) {
        when {
            sDeque.isEmpty() -> return false
            bDeque.peekFirst() > sDeque.peekFirst() -> sDeque.pollFirst()
            else -> {
                bDeque.pollFirst()
                sDeque.pollFirst()
            }
        }
    }
    return true
}