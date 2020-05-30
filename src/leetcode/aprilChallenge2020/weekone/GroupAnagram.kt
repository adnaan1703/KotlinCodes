package leetcode.aprilChallenge2020.weekone

fun main() {
    val ans = groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))
    for (itr1 in ans) {
        for (itr2 in itr1)
            print("$itr2 ")
        println()
    }
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val ans: ArrayList<ArrayList<String>> = ArrayList()
    val map: HashMap<String, Int> = HashMap()
    for (value in strs) {
        val encodedStr = encoder(value)
        if (map.containsKey(encodedStr)) {
            ans[map[encodedStr]!!].add(value)
        } else {
            val innerList = ArrayList<String>()
            innerList.add(value)
            ans.add(innerList)
            map[encodedStr] = ans.size - 1
        }
    }
    return ans
}

fun encoder(str: String): String {
    val arr = IntArray(26)
    for (value in str) {
        arr[value - 'a'] += 1
    }
    var code = ""
    for ((index, value) in arr.withIndex()) {
        if (value == 0)
            continue

        code += "$value${'a' + index}"
    }
    return code
}
