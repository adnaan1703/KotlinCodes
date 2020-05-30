package leetcode.maychallenge.weekfour

import java.util.*
import kotlin.collections.HashMap

fun main() {
    println(frequencySort("tree"))
}

fun frequencySort(s: String): String {
    val hashmap: HashMap<Char, Int> = HashMap()
    s.forEach { hashmap[it] = hashmap.getOrDefault(it, 0) + 1 }
    val tree: TreeSet<Pair<Char, Int>> = TreeSet() { o1, o2 ->
        treeComparator(
            o1,
            o2
        )
    }
    hashmap.forEach { (key, value) -> tree.add(key to value) }
    var ans = ""
    tree.forEach { pair: Pair<Char, Int> -> for (i in 1..pair.second) ans += pair.first }
    return ans
}

fun treeComparator(o1: Pair<Char, Int>, o2: Pair<Char, Int>): Int {
    val res = o2.second - o1.second
    return if (res != 0) res else 1
}