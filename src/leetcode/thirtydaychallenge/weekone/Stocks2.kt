package leetcode.thirtydaychallenge.weekone

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))        // ans: 7
    println(maxProfit(intArrayOf(1, 2, 3, 4, 5)))           // ans: 4
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))           // ans: 0
    println(maxProfit(intArrayOf(1, 1, 1, 1)))              // ans: 0
    println(maxProfit(intArrayOf(1, 1, 1, 2, 2)))           // ans: 1
    println(maxProfit(intArrayOf(1, 1, 1, 2, 2, 2, 3, 3)))  // ans: 2
    println(maxProfit(intArrayOf(4)))                       // ans: 0
    println(maxProfit(intArrayOf(3, 3, 3, 2, 2, 2, 1, 1)))  // ans: 0
}

fun maxProfit(prices: IntArray): Int {
    var ans = 0
    var boughtPrice = 0

    if (prices.size == 1)
        return 0

    for ((index, value) in prices.withIndex()) {
        if (index == 0) {
            boughtPrice = value
        } else if (index + 1 >= prices.size) {
            ans += if (prices[index - 1] < value) value - boughtPrice else 0
        } else if (prices[index - 1] >= value && prices[index + 1] > value) {
            boughtPrice = value
        } else if (prices[index - 1] < value && prices[index + 1] <= value)
            ans += value - boughtPrice
    }
    return ans
}