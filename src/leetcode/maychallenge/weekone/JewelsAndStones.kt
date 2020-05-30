package leetcode.maychallenge.weekone

import utils.println

fun main() {
    numJewelsInStones("aA", "aAAbbbb").println()
    numJewelsInStones("z", "ZZ").println()
}

fun numJewelsInStones(J: String, S: String): Int {
    val jewels = HashMap<Char, Int>()
    var counter = 0

    J.map { c -> jewels.put(c, 1) }
    S.map { c -> counter += jewels.getOrDefault(c, 0) }

    return counter
}