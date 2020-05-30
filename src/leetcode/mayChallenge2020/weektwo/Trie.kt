package leetcode.mayChallenge2020.weektwo

import utils.println

class Trie {

    private val _terminatingPosition = 26
    private val _terminatingNode = TrieNode()

    private val rootNode = TrieNode()

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        var node: TrieNode = rootNode
        word.forEach {
            val pos = it.getPos()
            if (node.nodes[pos] == null) {
                node.nodes[pos] = TrieNode()
            }
            node = node.nodes[pos]!!
        }
        node.nodes[_terminatingPosition] = _terminatingNode
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var node: TrieNode? = rootNode
        word.forEach {
            node = node?.nodes?.getOrNull(it.getPos())
        }
        return node?.nodes?.get(_terminatingPosition) != null
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var node: TrieNode? = rootNode
        prefix.forEach {
            node = node?.nodes?.getOrNull(it.getPos())
        }
        return node != null
    }

    private fun Char.getPos(): Int = this - 'a'

    private class TrieNode {
        val nodes = Array<TrieNode?>(27) { null }
    }

}

fun main() {
    val obj = Trie()
    obj.insert("applet")
    obj.insert("apple")
    obj.search("applet").println()
    obj.search("apple").println()
    obj.search("app").println()
    obj.startsWith("apple").println()
    obj.startsWith("app").println()
    obj.startsWith("applex").println()
}