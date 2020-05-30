package leetcode.aprilChallenge2020.weekfour

import utils.println

class FirstUnique(nums: IntArray) {
    private val duplicates = HashSet<Int>(nums.size)
    private val linkedHashset = LinkedHashSet<Int>(nums.size)

    init {
        for (num in nums) {
            add(num)
        }
    }

    fun showFirstUnique(): Int {
        return linkedHashset.firstOrNull() ?: -1
    }

    fun add(value: Int) {
        if (linkedHashset.contains(value)) {
            linkedHashset.remove(value)
            duplicates.add(value)
        } else if (duplicates.contains(value).not()) {
            linkedHashset.add(value)
        }
    }
}

fun main() {
    var firstUnique = FirstUnique(intArrayOf(2, 3, 5))
    firstUnique.showFirstUnique().println()     // ans: 2
    firstUnique.add(5)                          // the queue is now [2,3,5,5]
    firstUnique.showFirstUnique().println()     // ans: 2
    firstUnique.add(2)                          // the queue is now [2,3,5,5,2]
    firstUnique.showFirstUnique().println()     // ans: 3
    firstUnique.add(3)                          // the queue is now [2,3,5,5,2,3]
    firstUnique.showFirstUnique().println()     // ans: -1

    println()

    firstUnique = FirstUnique(intArrayOf(7, 7, 7, 7, 7, 7))
    firstUnique.showFirstUnique().println()     // ans: -1
    firstUnique.add(7)                          // the queue is now [7,7,7,7,7,7,7]
    firstUnique.add(3)                          // the queue is now [7,7,7,7,7,7,7,3]
    firstUnique.add(3)                          // the queue is now [7,7,7,7,7,7,7,3,3]
    firstUnique.add(7)                          // the queue is now [7,7,7,7,7,7,7,3,3,7]
    firstUnique.add(17)                         // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
    firstUnique.showFirstUnique().println()     // ans: 17

    println()

    firstUnique = FirstUnique(intArrayOf(809))
    firstUnique.showFirstUnique().println()     // ans: 809
    firstUnique.add(809)                        // the queue is now [809,809]
    firstUnique.showFirstUnique().println()     // ans: -1
}

