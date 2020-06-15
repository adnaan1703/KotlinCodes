package utils

import java.util.*

class TreeNode(var `val`: Int) {
    constructor(`val`: Int, left: TreeNode?, right: TreeNode?) : this(`val`) {
        this.`val` = `val`
        this.left = left
        this.right = right
    }

    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun printTree(root: TreeNode?) {
    val q: Queue<TreeNode?> = LinkedList()
    if (root != null)
        q.offer(root)

    while (q.isEmpty().not()) {
        val node = q.poll()
        print("${node?.`val` ?: "null"} ")
        if (node != null && (node.left != null || node.right != null)) {
            q.offer(node.left)
            q.offer(node.right)
        }
    }
    println()
}

