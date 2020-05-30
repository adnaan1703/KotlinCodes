package leetcode.aprilChallenge2020.weekone

fun main() {
    println(singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    println(singleNumber(intArrayOf(1, 2, 2)))
}

fun singleNumber(nums: IntArray): Int {
    var arr = 0
    nums.forEach { arr = arr xor it }
    return arr
}