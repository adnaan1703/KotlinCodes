package leetcode.thirtydaychallenge.weekfour

fun main() {
    println(subarraySum(intArrayOf(1, 1, 1), 2))
    println(subarraySum(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1), 3))
}

fun subarraySum(nums: IntArray, k: Int): Int {
    var counter = 0
    val map: HashMap<Int, Int> = HashMap()

    var sum = 0
    for (num in nums) {
        sum += num
        if (sum == k) counter++
        val pair = sum - k
        counter += map[pair] ?: 0
        map[sum] = map[sum]?.plus(1) ?: 1
    }
    return counter
}