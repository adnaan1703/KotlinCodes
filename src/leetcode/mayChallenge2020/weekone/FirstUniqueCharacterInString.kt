package leetcode.mayChallenge2020.weekone

import utils.println

fun main() {
    firstUniqChar("leetcode").println()
    firstUniqChar("loveleetcode").println()
    firstUniqChar("aadadaad").println()
    firstUniqChar("a").println()
    firstUniqChar("aa").println()
    firstUniqChar("").println()
}

fun firstUniqChar(s: String): Int {
    val frequency = IntArray(26)
    s.map { c -> frequency[c - 'a']++ }
    for ((index, char) in s.withIndex()) {
        if (frequency[char - 'a'] == 1)
            return index
    }
    return -1
}