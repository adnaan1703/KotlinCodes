package leetcode.thirtydaychallenge.weekthree

import utils.printWithSpace

fun main() {
    productExceptSelf(intArrayOf(1, 2, 3, 4)).printWithSpace()
    productExceptSelf(intArrayOf(1, 0, 3, 4)).printWithSpace()
    productExceptSelf(intArrayOf(1, 0, 0, 4)).printWithSpace()

    productExceptSelfNoDiv(intArrayOf(1, 2, 3, 4)).printWithSpace()
    productExceptSelfNoDiv(intArrayOf(1, 0, 3, 4)).printWithSpace()
    productExceptSelfNoDiv(intArrayOf(1, 0, 0, 4)).printWithSpace()

    productExceptSelfNoDivNoSpace(intArrayOf(1, 2, 3, 4)).printWithSpace()
    productExceptSelfNoDivNoSpace(intArrayOf(1, 0, 3, 4)).printWithSpace()
    productExceptSelfNoDivNoSpace(intArrayOf(1, 0, 0, 4)).printWithSpace()
}

fun productExceptSelf(nums: IntArray): IntArray {
    var zeroCount = 0
    var prodWithoutZero = 1

    for (num in nums) {
        if (num == 0) {
            zeroCount++
        } else {
            prodWithoutZero *= num
        }
    }

    val ans: IntArray = IntArray(nums.size)
    for (index in nums.indices) {
        when {
            zeroCount >= 2 -> {
                ans[index] = 0
            }
            zeroCount == 0 -> {
                ans[index] = prodWithoutZero / nums[index]
            }
            else -> {
                ans[index] = if (nums[index] == 0) prodWithoutZero else 0
            }
        }
    }
    return ans
}

fun productExceptSelfNoDiv(nums: IntArray): IntArray {
    val leftProd = IntArray(nums.size) { 1 }
    val rightProd = IntArray(nums.size) { 1 }
    val ans = IntArray(nums.size)

    for (i in 1..nums.lastIndex) {
        leftProd[i] = leftProd[i - 1] * nums[i - 1]
        rightProd[nums.lastIndex - i] = rightProd[nums.size - i] * nums[nums.size - i]
    }

    for (index in ans.indices) {
        ans[index] = leftProd[index] * rightProd[index]
    }
    return ans
}

fun productExceptSelfNoDivNoSpace(nums: IntArray): IntArray {
    val ans = IntArray(nums.size)
    for (index in nums.indices.reversed()) {
        if (index == nums.lastIndex) {
            ans[index] = 1
        } else {
            ans[index] = ans[index + 1] * nums[index + 1]
        }
    }

    var leftProd = nums[0]
    for (index in 1..nums.lastIndex) {
        ans[index] *= leftProd
        leftProd *= nums[index]
    }
    return ans
}