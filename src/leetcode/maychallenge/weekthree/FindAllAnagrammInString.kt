package leetcode.maychallenge.weekthree

@Suppress("SpellCheckingInspection")
fun main() {
    printArr(findAnagrams("cbaebabacd", "abc"))
    printArr(findAnagrams("abab", "ab"))
}

fun findAnagrams(s: String, pattern: String): List<Int> {
    val pArr: IntArray = createPatternArr(pattern)
    val sArr = IntArray(26)
    val ans = mutableListOf<Int>()
    var i = 0
    var j = 0

    while (j < pattern.length && j < s.length) {
        sArr[s[j] - 'a']++
        j++
    }
    if (sArr.same(pArr))
        ans.add(i)

    while (j < s.length) {
        sArr[s[j] - 'a']++
        sArr[s[i] - 'a']--
        if (sArr.same(pArr))
            ans.add(i + 1)
        j++
        i++
    }
    return ans
}

fun createPatternArr(pattern: String): IntArray {
    val arr = IntArray(26)
    pattern.forEach {
        arr[it - 'a']++
    }
    return arr
}

fun IntArray.same(arr: IntArray): Boolean {
    arr.forEachIndexed { index, i ->
        if (this[index] != i)
            return false
    }
    return arr.size == this.size
}

fun printArr(arr: List<Int>) {
    arr.forEach {
        print("$it ")
    }
    println()
}


