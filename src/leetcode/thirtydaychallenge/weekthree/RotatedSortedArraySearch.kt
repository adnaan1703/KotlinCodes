package leetcode.thirtydaychallenge.weekthree

fun main() {
    println(search(intArrayOf(1, 2, 3, 4, 5), 4))
    println(search(intArrayOf(1, 2, 3, 4, 0), 4))
    println(search(intArrayOf(3, 4, 5, 1, 2), 4))
    println(search(intArrayOf(1), 1))

    println(search(intArrayOf(1, 2, 3, 4, 5), 14))
    println(search(intArrayOf(1, 2, 3, 4, 0), 14))
    println(search(intArrayOf(3, 4, 5, 1, 2), 14))
    println(search(intArrayOf(1), 11))
}

fun search(nums: IntArray, target: Int): Int {
    var pivot = pivotPoint(nums)
    pivot = if (pivot >= 0) pivot else 0
    val left = binarySearch(nums, 0, pivot - 1, target)
    val right = binarySearch(nums, pivot, nums.lastIndex, target)

    return when {
        left > -1 -> left
        right > -1 -> right
        else -> -1
    }
}

fun binarySearch(nums: IntArray, l: Int, h: Int, target: Int): Int {
    var low = l
    var high = h
    while (low <= high) {
        val mid = (low + high) shr 1
        if (nums[mid] == target)
            return mid

        if (target > nums[mid])
            low = mid + 1
        else
            high = mid - 1
    }
    return -1
}

fun pivotPoint(nums: IntArray): Int {
    var low = 0
    var high = nums.lastIndex

    while (low < high) {
        val mid = (low + high) shr 1

        if (mid > low && nums[mid] < nums[mid - 1])
            return mid
        if (mid < high && nums[mid] > nums[mid + 1])
            return mid + 1

        if (nums[mid] > nums[low]) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return if (low == high) low else -1
}