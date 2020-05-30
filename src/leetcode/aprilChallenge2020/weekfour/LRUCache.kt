package leetcode.aprilChallenge2020.weekfour

class LRUCache(private val capacity: Int) {

    private val map: HashMap<Int, Node> = HashMap()
    private val linkedList: LRULinkList = LRULinkList()

    fun get(key: Int): Int {
        val node: Node = map[key] ?: return -1
        linkedList.promote(node)
        return node.value
    }

    fun put(key: Int, value: Int) {

        map[key]?.let {
            it.value = value
            linkedList.promote(it)
        } ?: run {
            val node = Node(key, value)
            if (linkedList.size >= capacity) {
                map.remove(linkedList.last?.key)
                linkedList.pollLast()
            }
            map[key] = node
            linkedList.offerFirst(node)
        }
    }

    class Node(val key: Int, var value: Int, var prev: Node? = null, var next: Node? = null)

    class LRULinkList {

        private var first: Node? = null
        var last: Node? = null
        var size: Int = 0

        fun offerFirst(node: Node) {
            node.next = first
            first?.prev = node
            first = node
            if (size == 0) last = node
            size++
        }

        fun pollLast() {
            val l = last
            last = last?.prev
            last?.next = null

            l?.prev = null
            l?.next = null
            size--
            if (size == 0) first = null
        }

        private fun pollFirst() {
            val f = first
            first = first?.next
            first?.prev = null

            f?.prev = null
            f?.next = null
            size--
            if (size == 0) last = null
        }

        private fun pollMiddle(node: Node) {
            node.prev?.next = node.next
            node.next?.prev = node.prev

            node.next = null
            node.prev = null
            size--
        }

        private fun removeNode(node: Node) {
            when (node) {
                first -> pollFirst()
                last -> pollLast()
                else -> pollMiddle(node)
            }
        }

        fun promote(node: Node) {
            removeNode(node)
            offerFirst(node)
        }
    }
}

fun main() {
    val cache = LRUCache(2)
    cache.put(1, 1)
    cache.put(2, 2)
    cache.printAndGet(1)        // returns 1
    cache.put(3, 3)                   // evicts key 2
    cache.printAndGet(2)        // returns -1 (not found)
    cache.put(4, 4)                   // evicts key 1
    cache.printAndGet(1)        // returns -1 (not found)
    cache.printAndGet(3)        // returns 3
    cache.printAndGet(4)        // returns 4
}

fun LRUCache.printAndGet(key: Int) {
    println(this.get(key))
}
