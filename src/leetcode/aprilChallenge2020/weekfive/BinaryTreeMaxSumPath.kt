package leetcode.aprilChallenge2020.weekfive

import utils.print
import kotlin.math.max

class TreeNode(val `val`: Int, val left: TreeNode? = null, val right: TreeNode? = null)

private fun maxPathSum(root: TreeNode?): Int {
    val maxValue = intArrayOf(Int.MIN_VALUE)
    if (root == null)
        return 0

    travelBinaryTree(root, maxValue)
    return maxValue[0]
}

private fun travelBinaryTree(root: TreeNode, maxValue: IntArray): Int {
    var leftSum = 0
    var rightSum = 0
    if (root.left != null) {
        leftSum = travelBinaryTree(root.left, maxValue)
    }

    if (root.right != null) {
        rightSum = travelBinaryTree(root.right, maxValue)
    }

    val currentMax = max(leftSum, rightSum)
    val currentSum = if (currentMax >= 0) currentMax + root.`val` else root.`val`

    maxValue[0] = intArrayOf(maxValue[0], currentSum, leftSum + rightSum + root.`val`).max() ?: Int.MIN_VALUE
    return currentSum
}


fun main() {
    val left = TreeNode(2)
    val right = TreeNode(-3)
    val root = TreeNode(1, left, right)
    maxPathSum(root).print()
}
