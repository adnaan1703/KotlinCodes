package leetcode.juneChallenge2020.weektwo

import utils.println

@Suppress("SpellCheckingInspection")
fun main() {
    isSubsequence("abc", "asdbwerewcyry").println()
    isSubsequence("axc", "asdbwerewcyry").println()
}

fun isSubsequence(s: String, t: String): Boolean {
    var index1 = 0
    var index2 = 0

    while (index1 < s.length && index2 < t.length) {
        if (s[index1] == t[index2]) index1++
        index2++
    }
    return index1 == s.length
}