package leetcode.thirtydaychallenge.weekfour

class LRUCache2(private var capacity: Int) : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
    override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
        return this.size > capacity
    }

    override fun get(key: Int): Int? {
        return this.getOrDefault(key, -1)
    }
}

fun main() {
    val cache = LRUCache2(2)
    cache[1] = 1
    cache[2] = 2
    cache.getAndPrint(1)       // returns 1
    cache[3] = 3                     // evicts key 2
    cache.getAndPrint(2)       // returns -1 (not found)
    cache[4] = 4                     // evicts key 1
    cache.getAndPrint(1)       // returns -1 (not found)
    cache.getAndPrint(3)       // returns 3
    cache.getAndPrint(4)       // returns 4
}

fun LRUCache2.getAndPrint(key: Int) {
    println(this[key])
}