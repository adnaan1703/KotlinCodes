package leetcode.julyChallenge2020.weekone

import utils.TreeNode
import utils.print
import java.util.*

fun main() {
    val node15 = TreeNode(15)
    val node7 = TreeNode(7)
    val node9 = TreeNode(9)
    val node20 = TreeNode(20, node15, node7)
    val node3 = TreeNode(3, node9, node20)

    levelOrderBottom(node3).print()
}

fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
    val delimiterNode = TreeNode(Int.MIN_VALUE)
    val ans: MutableList<MutableList<Int>> = mutableListOf()
    val queue: Queue<TreeNode> = LinkedList()

    if (root == null)
        return ans

    queue.offer(root)
    queue.offer(delimiterNode)
    ans.add(mutableListOf())

    while (queue.isEmpty().not()) {
        val element: TreeNode = queue.poll()
        if (element == delimiterNode && queue.isEmpty().not()) {
            queue.offer(delimiterNode)
            ans.add(mutableListOf())
        } else if (element != delimiterNode) {
            ans.last().add(element.`val`)
            if (element.left != null) queue.offer(element.left)
            if (element.right != null) queue.offer(element.right)
        }
    }
    return ans.reversed()
}
