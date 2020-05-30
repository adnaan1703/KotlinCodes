package leetcode.mayChallenge2020.weekthree

import utils.TreeNode
import utils.println

fun main() {
    val node1 = TreeNode(1)
    node1.right = TreeNode(2)
    val root = TreeNode(3)
    root.left = node1
    root.right = TreeNode(4)
    kthSmallest(root, 1).println()
}

fun kthSmallest(root: TreeNode?, k: Int): Int {
    val treeRecurSolver = TreeRecurSolver(k)
    treeRecurSolver.recurInOrder(root)
    return treeRecurSolver.ans
}

private class TreeRecurSolver(val k: Int) {
    var index = 0
    var ans = -1

    fun recurInOrder(root: TreeNode?) {
        if (root == null || ans != -1)
            return

        recurInOrder(root.left)

        ++index
        if (index == k) ans = root.`val`

        recurInOrder(root.right)
    }
}
