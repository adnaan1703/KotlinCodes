package leetcode.juneChallenge2020.weektwo

import utils.println
import kotlin.random.Random

fun main() {
    val randomSet = RandomizedSet()
    randomSet.insert(1).println()
    randomSet.insert(2).println()
    randomSet.getRandom().println()
    randomSet.getRandom().println()
    randomSet.remove(2).println()
    randomSet.remove(70).println()
    randomSet.getRandom().println()
}

class RandomizedSet {

    private var endIndex = -1
    private val hashMap = mutableMapOf<Int, Int>()
    private val reverseMap = mutableMapOf<Int, Int>()

    // return true if val wasn't there before in the set
    fun insert(`val`: Int): Boolean {
        if (hashMap.containsKey(`val`))
            return false
        endIndex++
        hashMap[`val`] = endIndex
        reverseMap[endIndex] = `val`
        return true
    }

    // return true if val was there in the set
    fun remove(`val`: Int): Boolean {
        if (hashMap.containsKey(`val`).not())
            return false

        val originalIndex = hashMap[`val`]!!
        val lastValue = reverseMap[endIndex]!!

        hashMap.swap(`val`, lastValue)
        reverseMap.swap(originalIndex, endIndex)

        hashMap.remove(`val`)
        reverseMap.remove(endIndex)
        endIndex--
        return true
    }

    fun getRandom(): Int {
        val random = Random.nextInt(0, endIndex + 1)
        return reverseMap[random]!!
    }

    private fun MutableMap<Int, Int>.swap(i: Int, j: Int) {
        val temp = this[i]!!
        this[i] = this[j]!!
        this[j] = temp
    }
}
