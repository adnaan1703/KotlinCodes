package leetcode.aprilChallenge2020.weekone

fun main() {
    println(countElements(intArrayOf(1, 2, 3)))
    println(countElements(intArrayOf(1, 1, 3, 3, 5, 5, 7, 7)))
    println(countElements(intArrayOf(1, 3, 2, 3, 5, 0)))
    println(countElements(intArrayOf(1, 1, 2, 2)))
}

/*
 * Using custom hash where boolean array is used.
 */

fun countElements(arr: IntArray): Int {
    var count = 0
    val hash = Array(1002) { false }
    for (value in arr) {
        hash[value] = true
    }

    for (value in arr) {
        if (hash[value + 1])
            count++
    }
    return count
}

/*
 * using hashset api
 */

fun countElements2(arr: IntArray): Int {
    var count = 0
    val hash: HashSet<Int> = HashSet()
    for (value in arr) {
        hash.add(value)
    }

    for (value in arr) {
        if (hash.contains(value + 1))
            count++
    }
    return count
}