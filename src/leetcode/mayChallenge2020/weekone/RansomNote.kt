package leetcode.mayChallenge2020.weekone

import utils.println

fun main() {
    canConstruct2("a", "b").println()
    canConstruct2("aa", "ab").println()
    canConstruct2("aa", "aab").println()
}

fun canConstruct2(ransomNote: String, magazine: String): Boolean {
    val lettersMap = IntArray(26) { 0 }
    magazine.map { c -> lettersMap[c - 'a']++ }
    for (c in ransomNote) {
        if (lettersMap[c - 'a'] == 0)
            return false
        else
            lettersMap[c - 'a']--
    }
    return true
}