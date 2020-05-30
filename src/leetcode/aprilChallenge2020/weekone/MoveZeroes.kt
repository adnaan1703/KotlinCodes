package leetcode.aprilChallenge2020.weekone

import utils.printWithSpace

fun main() {
    driver(intArrayOf(0, 0, 3))             // ans: 3, 0, 0
    driver(intArrayOf(3, 1, 0))             // ans: 3, 1, 0
    driver(intArrayOf(0, 1, 0, 3, 12))      // ans: 1, 3, 12, 0, 0

    println("============= now with swaps =============")

    driverWithSwap(intArrayOf(0, 0, 3))             // ans: 3, 0, 0
    driverWithSwap(intArrayOf(3, 1, 0))             // ans: 3, 1, 0
    driverWithSwap(intArrayOf(0, 1, 0, 3, 12))      // ans: 1, 3, 12, 0, 0
}

fun driver(nums: IntArray) {
    moveZeroes(nums)
    nums.printWithSpace()
}

fun driverWithSwap(nums: IntArray) {
    moveZeroesWithSwap(nums)
    nums.printWithSpace()
}

fun moveZeroes(nums: IntArray) {
    var ptr = 0
    for (value in nums) {
        if (value != 0)
            nums[ptr++] = value
    }

    for (itr in ptr until nums.size)
        nums[itr] = 0
}

/*
 * ==============
 * JUST FOR FUN
 * ==============
 *
 * Basically if this problem was needed to be solved with swap
 * For example instead of being a simple values it was objects.
 *
 */

fun moveZeroesWithSwap(nums: IntArray) {
    var zeroPtr = 0
    var nonZeroPtr = 0

    while (nonZeroPtr < nums.size && zeroPtr < nums.size) {
        nonZeroPtr = findPtr(nums, nonZeroPtr) { it != 0 }
        zeroPtr = findPtr(nums, zeroPtr) { it == 0 }

        if (zeroPtr >= nums.size || nonZeroPtr >= nums.size)
            break

        if (zeroPtr < nonZeroPtr) {
            nums[zeroPtr] = nums[zeroPtr] xor nums[nonZeroPtr]
            nums[nonZeroPtr] = nums[zeroPtr] xor nums[nonZeroPtr]
            nums[zeroPtr] = nums[zeroPtr] xor nums[nonZeroPtr]

            zeroPtr++
            nonZeroPtr++
        } else if (zeroPtr > nonZeroPtr) {
            nonZeroPtr++
        }
    }
}

fun findPtr(nums: IntArray, ptr: Int, predicate: (value: Int) -> Boolean): Int {
    var mPtr = ptr
    while (mPtr < nums.size) {
        if (predicate(nums[mPtr])) {
            break
        }
        mPtr++
    }
    return mPtr
}