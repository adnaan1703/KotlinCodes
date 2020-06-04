package leetcode.juneChallenge2020.weekone

fun main() {
    var s = charArrayOf('a', 'd', 'n', 'a', 'a', 'n')
    reverseString(s)
    println(s)

    s = charArrayOf('a', 'd', 'n', 'a', 'n')
    reverseString(s)
    println(s)
}

fun reverseString(s: CharArray) {
    var index = 0

    while (index < s.size / 2) {
        val temp = s[index]
        s[index] = s[s.lastIndex - index]
        s[s.lastIndex - index] = temp
        index++
    }
}