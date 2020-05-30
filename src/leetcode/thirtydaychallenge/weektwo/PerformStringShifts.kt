package leetcode.thirtydaychallenge.weektwo

fun main() {
    println(
        stringShift(
            "abcdefg", arrayOf(
                intArrayOf(1, 1),
                intArrayOf(1, 1),
                intArrayOf(0, 2),
                intArrayOf(1, 3)
            )
        )
    )
}

fun stringShift(s: String, shift: Array<IntArray>): String {
    var ptr = 0
    var ans = ""
    for (itr in shift) {
        ptr += if (itr[0] == 0) itr[1] else (-1) * itr[1]
        ptr %= s.length
    }
    ptr = if (ptr >= 0) ptr else s.length + ptr
    return "${s.substring(ptr)}${s.substring(0, ptr)}"
}