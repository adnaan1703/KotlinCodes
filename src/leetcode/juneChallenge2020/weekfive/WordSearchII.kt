package leetcode.juneChallenge2020.weekfive

import utils.print

fun main() {
    val board = arrayOf(
        charArrayOf('o', 'a', 'a', 'n'),
        charArrayOf('e', 't', 'a', 'e'),
        charArrayOf('i', 'h', 'k', 'r'),
        charArrayOf('i', 'f', 'l', 'v')
    )
    findWords(board, arrayOf("oath", "pea", "eat", "rain")).print()
}

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    val trie = WordSearchTrie()
    val wordsFound = HashSet<String>()
    val rows = board.size
    val cols = board[0].size
    val visited = Array(rows) { BooleanArray(cols) }

    words.forEach { trie.insert(it) }
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            traverse(board, visited, "", i, j, trie, wordsFound)
        }
    }
    return wordsFound.toList()
}

private fun traverse(
    board: Array<CharArray>,
    visited: Array<BooleanArray>,
    str: String,
    i: Int,
    j: Int,
    trie: WordSearchTrie,
    wordsFound: HashSet<String>
) {

    if (board.getOrNull(i)?.getOrNull(j) == null || visited[i][j])
        return

    val word = str + board[i][j]
    if (trie.startsWith(word).not())
        return

    if (trie.search(word)) {
        wordsFound.add(word)
    }

    visited[i][j] = true
    traverse(board, visited, word, i + 1, j, trie, wordsFound)
    traverse(board, visited, word, i - 1, j, trie, wordsFound)
    traverse(board, visited, word, i, j + 1, trie, wordsFound)
    traverse(board, visited, word, i, j - 1, trie, wordsFound)
    visited[i][j] = false
}

private class WordSearchTrie {
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
