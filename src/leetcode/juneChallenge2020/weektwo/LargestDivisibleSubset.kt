package leetcode.juneChallenge2020.weektwo

import utils.print

fun main() {
    largestDivisibleSubset(intArrayOf()).print()
    largestDivisibleSubset(intArrayOf(1, 2, 3)).print()
    largestDivisibleSubset(intArrayOf(1, 2, 4, 8)).print()
}

fun largestDivisibleSubset(nums: IntArray): List<Int> {
    if (nums.isEmpty())
        return listOf()

    val dp = Array(nums.size) { 0 to 0 }
    var maxPair = -1 to -1

    nums.sort()
    nums.forEachIndexed { index, it ->
        var maxx = 0 to -1
        for (i in 0 until index) {
            if (it % nums[i] == 0 && dp[i] > maxx)
                maxx = dp[i].first to i
        }
        dp[index] = maxx.first + 1 to maxx.second
        if (dp[index] > maxPair) maxPair = dp[index].first to index
    }
    val ans = mutableListOf<Int>()
    var index = maxPair.second
    while (index != -1) {
        ans.add(nums[index])
        index = dp[index].second
    }
    return ans
}

private operator fun Pair<Int, Int>.compareTo(arg: Pair<Int, Int>): Int {
    return this.first - arg.first
}
